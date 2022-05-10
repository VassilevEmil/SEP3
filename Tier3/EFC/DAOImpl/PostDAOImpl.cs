using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Entities.Contracts;
using Entities.Models;
using Microsoft.EntityFrameworkCore;

namespace EFC.DAOImpl; 

public class PostDAOImpl : IPostService {

    private readonly DbAccess _context;

    public PostDAOImpl(DbAccess context) {
        _context = context;
    }


    public async Task<Post> AddPost(int subCategoryId,Post post) {
        var subcategory = await _context.Subcategories.FindAsync(subCategoryId);
        var user = await _context.Users.FindAsync(post.Writer.Username);

        post.Writer = user!;
        post.Subcategory = subcategory!;

        var entityEntry = await _context.Posts.AddAsync(post);
        await _context.SaveChangesAsync();
        return entityEntry.Entity;
    }

    public Task<List<Category>> GetAllCategories() {
        return Task.FromResult(_context.Categories.
            Include(category => category.Subcategories)
            .ToList());
    }

    public Task<List<Post>> GetAllPosyByUserName(string userName)
    {
        List<Post> postsByUser = _context.Posts.Where(post => post.Writer.Username.Equals (userName)).Include(post
            => post.Subcategory).Include(p
            => p.Subcategory.Category).ToList();
        return Task.FromResult(postsByUser);
    }

    public Task<List<Post>> GetAllPostBySubCategory(int subcategoryId)
    {
        var postOnSubCategory = _context.Posts.Where(post => post.Subcategory.Id.Equals(subcategoryId)).Include(post => post.Writer.Username).ToList();
        return Task.FromResult(postOnSubCategory);
    }
}