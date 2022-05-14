using System.Runtime.InteropServices;
using Entities.Models;

namespace Contracts; 

public interface IPostService {
    Task<Post> AddPostAsync(int subCategoryId, Post postToAdd,[Optional] MultipartFormDataContent formDataContent);
    Task<List<Category>> GetALlCategoriesAsync();

    Task<List<Post>> GetAllPosts(int current);

    Task<Post> GetPostDetails(int Id);

    Task<List<Post>> SearchPosts(string title, int current);
    Task<List<Post>?> GetPostsBySubCategoryId(int subCategoryIdSelected, int current);
}