using Entities.Contracts;
using Entities.Models;
using Microsoft.EntityFrameworkCore;

namespace EFC.DAOImpl;

public class ImageDaoImpl : IImageService

{
    private readonly DbAccess _context;

    public ImageDaoImpl(DbAccess context)
    {
        _context = context;
    }


    public async Task<bool> AddImage(int postId, string fileType, byte[] file)
    {
        Image image = new Image();
        image.PostId = postId;
        image.Href=String.Empty;
        var returnImage =  _context.Images.AddAsync(image).Result.Entity;
        await _context.SaveChangesAsync();
        Console.WriteLine(returnImage.Id.ToString() + "Id of returned image");
        var href = returnImage.Id + "." + fileType;
        if (ByteArrayToFile(href, file))
        {
            returnImage.Href = href;
            await _context.SaveChangesAsync();
            return true;
        }
        else
        {
            return false;
        }
    }


    private bool ByteArrayToFile(string fileName, byte[] byteArray)
    {
        try
        {
            using (var fs = new FileStream(fileName, FileMode.Create, FileAccess.Write))
            {
                fs.Write(byteArray, 0, byteArray.Length);
                return true;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Exception caught in process: {0}", ex);
            return false;
        }
    }
}