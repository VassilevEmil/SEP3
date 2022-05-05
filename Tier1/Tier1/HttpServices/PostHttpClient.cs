using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices; 

public class PostHttpClient : IPostService {
    public async Task<Post> AddPostAsync(int subCategoryId, Post postToAdd) {
        try {
            string client =await ClientAPI.getContent(Methods.Post, $"/post/{subCategoryId}", postToAdd);
            Post postFromServer = JsonSerializer.Deserialize<Post>(client, new JsonSerializerOptions() {
                PropertyNameCaseInsensitive = true
            }) !;
            return postFromServer;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }

    }
}