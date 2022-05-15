using Entities.Models;

namespace Entities.Contracts;

public interface IBookmarkService
{
    Task<Bookmark> AddBookmark(Bookmark bookmark);
    Task<Bookmark> RemoveBookmark(int postid, String username);
    Task<List<Post>> getListOfBookedElements(string username);
}