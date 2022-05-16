using System.Runtime.InteropServices;
using Entities.Contracts;
using Entities.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EFC.DAOImpl; 

public class CommentDAOImpl : ICommentService {
    private readonly DbAccess _context;


    public CommentDAOImpl(DbAccess context) {
        _context = context;
    }

    public async Task<Comment> AddComment(int postId, Comment commentToAdd) {
        var post = await _context.Posts.FindAsync(postId);
        var user = await _context.Users.FindAsync(commentToAdd.Writer.Username);

        commentToAdd.Writer = user!;
        commentToAdd.Post = post!;
        var entityEntry = await _context.Comments.AddAsync(commentToAdd);
        await _context.SaveChangesAsync();
        return entityEntry.Entity;
    }

    public async Task<Comment> DeleteComment(int commentId) {
        Comment? comment = await _context.Comments
            .Include(comment1 => comment1.Writer)
            .FirstAsync(comment1 => comment1.Id==commentId);
        if (comment == null) throw new Exception("Comment not found to delete");
        EntityEntry<Comment> entityEntry = _context.Comments.Remove(comment);
        await _context.SaveChangesAsync();
        return entityEntry.Entity;
    }
}