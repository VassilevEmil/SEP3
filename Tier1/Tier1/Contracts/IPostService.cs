using Entities.Models;

namespace Contracts; 

public interface IPostService {
    Task<Post> AddPostAsync(int subCategoryId, Post postToAdd);
    Task<List<Category>> GetALlCategoriesAsync();

    Task<List<Post>> GetPostsByName(string name);
    Task<List<Post>> GetAllPosts();
}