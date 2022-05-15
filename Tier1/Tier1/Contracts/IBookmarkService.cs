using Entities.Models;

namespace Contracts;

public interface IBookmarkService
{
    Task<Bookmark> AddBookmark(Bookmark bookmark);
    Task<Bookmark> RemoveBookmark(Bookmark bookmark);
    Task<List<Post>> getListOfBookedElements(string username);
}