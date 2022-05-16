using Entities.Models;

namespace Entities.Contracts; 

public interface IPostService { 
    Task<Post> AddPost(int subCategoryId,Post post);
    Task<List<Category>> GetAllCategories();

    Task<List<Post>> GetAllPostsByUsername(string userName);
    Task<List<Post>> GetAllPost(int current);
    Task<List<Post>> SearchPosts(string titleToSearch, int current);
    Task<Post> GetPostDetails(int id);

    Task<List<Post>> GetPostsBySubcategoryId(int subcategoryId, int current);

    Task<string> AddImage(int id);
}