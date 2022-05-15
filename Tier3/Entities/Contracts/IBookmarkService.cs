using Entities.Models;

namespace Entities.Contracts;

public interface IBookmarkService
{
    Task AddBookmark(Bookmark bookmark);
    Task RemoveBookmark(int postid, String username);
}