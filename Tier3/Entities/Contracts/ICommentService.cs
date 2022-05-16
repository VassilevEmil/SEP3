using Entities.Models;

namespace Entities.Contracts; 

public interface ICommentService {
    Task<Comment> AddComment(int postId, Comment commentToAdd);
    Task<Comment> DeleteComment(int commentId);
}