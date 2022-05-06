using Entities.Models;

namespace Entities.Contracts; 

public interface IPostService { 
    Task<Post> AddPost(int subCategoryId,Post post);
    Task<List<Category>> GetAllCategories();
}