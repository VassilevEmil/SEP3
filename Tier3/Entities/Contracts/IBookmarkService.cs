using Entities.Models;

namespace Entities.Contracts;

public interface IBookmarkService
{
    Task AddBookmark(Bookmark bookmark);
    Task RemoveBookmark(Bookmark bookmark);
}