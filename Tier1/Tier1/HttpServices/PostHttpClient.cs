using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices; 

public class PostHttpClient : IPostService {
    public async Task<Post> AddPostAsync(int subCategoryId, Post postToAdd) {
        try {
            string client =await ClientAPI.getContent(Methods.Post, "/post/" +subCategoryId, postToAdd);
            Post postFromServer = GetDeserialized<Post>(client);
            return postFromServer;
        }
        catch (Exception e) {
            throw new Exception(e.Message + " " + e.StackTrace);
        }

    }

    public async Task<List<Category>> GetALlCategoriesAsync() {
        try {
            string client = await ClientAPI.getContent(Methods.Get, "/allCategories");
            List<Category> list = GetDeserialized<List<Category>>(client);
            return list;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }

    }

    public async Task<List<Post>> GetPostsByName(string name)
    {
        try {
            string client = await ClientAPI.getContent(Methods.Get, $"/post/{name}");
            List<Post> list = GetDeserialized<List<Post>>(client);
            return list;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }

    public async Task<List<Post>> GetAllPosts(int current)
    {
        try {
            string client = await ClientAPI.getContent(Methods.Get, $"/post/all/{current}");
            List<Post> list = GetDeserialized<List<Post>>(client);
            return list;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }

    public async Task<List<Post>> SearchPosts(string title) {
        try {
            string client = await ClientAPI.getContent(Methods.Get, $"/search/{title}");
            List<Post> listFromServer = GetDeserialized<List<Post>>(client);
            return listFromServer;
        }
        catch (Exception e) {
            throw new Exception(e.Message);
        }
    }


    public async Task<Post> GetPostDetails(int Id)
    {
        try
        {
            string client = await ClientAPI.getContent(Methods.Get, $"/PostDetails/{Id}");
            Post post = GetDeserialized<Post>(client);
            Console.WriteLine(post.Writer.Username);
            return post;
        }
        catch (Exception e)
        {
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