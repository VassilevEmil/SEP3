using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices;

public class CommentHttpClient : ICommentService {
    public async Task<Comment> AddComment(int postId, Comment comment) {
        try {
            var content = await ClientAPI.getContent(Methods.Post, $"/comments/{postId}", comment);
            Comment deserialized = GetDeserialized<Comment>(content);
            return deserialized;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }

    public async Task<Comment> DeleteComment(int commentId) {
        try {
            var content = await ClientAPI.getContent(Methods.Delete, $"/comments/{commentId}");
            var commentFromServer = GetDeserialized<Comment>(content);
            return commentFromServer;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }


    private T GetDeserialized<T>(string jsonFormat) {
        T obj = JsonSerializer.Deserialize<T>(jsonFormat, new JsonSerializerOptions() {
            PropertyNameCaseInsensitive = true
        }) !;
        return obj;
    }
}