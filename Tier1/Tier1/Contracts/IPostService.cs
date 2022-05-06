using Entities.Models;

namespace Contracts; 

public interface IPostService {
    Task<Post> AddPostAsync(int subCategoryId, Post postToAdd);
    Task<List<Category>> GetALlCategoriesAsync();
}