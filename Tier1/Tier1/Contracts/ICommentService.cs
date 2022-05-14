using Entities.Models;

namespace Contracts; 

public interface ICommentService {


    Task<Comment> AddComment(int postId, Comment comment);

}