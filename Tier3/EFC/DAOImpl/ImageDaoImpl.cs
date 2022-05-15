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


    public async Task<bool> AddImage(int postId,string fileType, byte[] file)
    {
        Image image = new Image();
         var post= _context.Posts.FirstOrDefaultAsync(post => postId.Equals(post.Id)).Result;
            post.Images.Add(image);
            
            var a =  _context.Posts.Update(post);

            string filename =  a.Entity.Images.Count+"."+fileType;

            if (ByteArrayToFile(filename, file))
            {
                image.Id = Convert.ToInt32(filename);
                image.Href = filename;
                var imageDb = _context.Images.Update(image);
                await _context.SaveChangesAsync();
                return true;
            }
            else
            {
                return false;
            }



    }
    
    
    private bool ByteArrayToFile(string fileName, byte[] byteArray) {
        try {
            using (var fs = new FileStream(fileName, FileMode.Create, FileAccess.Write)) {
                fs.Write(byteArray, 0, byteArray.Length);
                return true;
            }
        }
        catch (Exception ex) {
            Console.WriteLine("Exception caught in process: {0}", ex);
            return false;
        }
    }
}