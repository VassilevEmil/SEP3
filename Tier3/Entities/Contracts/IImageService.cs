namespace Entities.Contracts;

public interface IImageService
{
    Task<bool> AddImage(int postId, string fileType, byte[] file);
}