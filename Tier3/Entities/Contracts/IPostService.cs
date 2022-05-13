using Entities.Models;

namespace Entities.Contracts; 

public interface IPostService { 
    Task<Post> AddPost(int subCategoryId,Post post);
    Task<List<Category>> GetAllCategories();

    Task<List<Post>> GetAllPosyByUserName(string userName);

    Task<List<Post>> GetAllPostBySubCategory(int subcategoryId);
    Task<List<Post>> GetAllPost(int current);
    Task<List<Post>> SearchPosts(string titleToSearch);
    Task<Post> GetPostDetails(int Id);

}