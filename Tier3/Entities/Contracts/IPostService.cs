using Entities.Models;

namespace Entities.Contracts; 

public interface IPostService { 
    Task<Post> AddPost(Post post);
}