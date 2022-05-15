using Entities.Contracts;
using Entities.Models;
using Microsoft.EntityFrameworkCore;

namespace EFC.DAOImpl;

public class BookmarkDAOImpl : IBookmarkService
{
    private readonly DbAccess _context;

    public BookmarkDAOImpl(DbAccess context) {
        _context = context;
    }
    
    public async Task<Bookmark> AddBookmark(Bookmark bookmark)
    {
        Bookmark bookmarkLocal = new Bookmark();
        bookmarkLocal.Post = await _context.Posts.FindAsync(bookmark.Post.Id);
        bookmarkLocal.User = await _context.Users.FirstAsync(t=>t.Username.Equals(bookmark.User.Username));

        await _context.Bookmarks.AddAsync(bookmarkLocal);
        await _context.SaveChangesAsync();
        return bookmarkLocal;
    }

    public async Task<Bookmark> RemoveBookmark(int postid, string username)
    {
        Bookmark bookmarkLocal = await _context.Bookmarks.FirstAsync(t=>t.PostId.Equals(postid)&&t.Username.Equals(username));
        _context.Bookmarks.Remove(bookmarkLocal);
        await _context.SaveChangesAsync();
        return bookmarkLocal;
    }
}