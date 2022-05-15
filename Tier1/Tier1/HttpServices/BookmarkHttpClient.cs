using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices;

public class BookmarkHttpClient : IBookmarkService
{
    
    private T GetDeserialized<T>(string jsonFormat) {
        T obj = JsonSerializer.Deserialize<T>(jsonFormat, new JsonSerializerOptions() {
            PropertyNameCaseInsensitive = true
        }) !;
        return obj;
    }

    public async Task<Bookmark> AddBookmark(Bookmark bookmark)
    {
        try {
            var content = await ClientAPI.getContent(Methods.Post, $"/bookmark", bookmark);
            Bookmark retur = GetDeserialized<Bookmark>(content);
            return retur;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }

    public async Task<Bookmark> RemoveBookmark(Bookmark bookmark)
    {
        try {
            var content = await ClientAPI.getContent(Methods.Delete, $"/bookmark/{bookmark.Post.Id}/{bookmark.User.Username}");
            Bookmark retur = GetDeserialized<Bookmark>(content);
            return retur;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }

    public async Task<List<Post>> getListOfBookedElements(string username)
    {
        try {
            var content = await ClientAPI.getContent(Methods.Get, $"/bookmark/getAllPosts/{username}");
            List<Post> retur = GetDeserialized<List<Post>>(content);
            return retur;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }
}