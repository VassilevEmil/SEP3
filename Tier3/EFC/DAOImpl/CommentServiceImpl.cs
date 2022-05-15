using System.Runtime.InteropServices;
using Entities.Contracts;
using Entities.Models;

namespace EFC.DAOImpl; 

public class CommentServiceImpl : ICommentService {
    private readonly DbAccess _context;


    public CommentServiceImpl(DbAccess context) {
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
}