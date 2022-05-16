using System.Runtime.InteropServices;
using System.Text;
using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices;

public class PostHttpClient : IPostService
{
    /**  public async Task<Post> AddPostAsync(int subCategoryId, Post postToAdd) {
        try {
            string client =await ClientAPI.getContent(Methods.Post, "/post/" +subCategoryId, postToAdd);
            Post postFromServer = GetDeserialized<Post>(client);
            return postFromServer;
        }
        catch (Exception e) {
            throw new Exception(e.Message + " " + e.StackTrace);
        }

    }
    **/

    // Adding post with  image
    public async Task<Post> AddPostAsync(int subCategoryId, Post postToAdd, [Optional] MultipartFormDataContent form)
    {
        string content = string.Empty;
        Post post = new Post();
        MultipartFormDataContent? formDataContent = form;

        try
        {
            using (var httpClient = new HttpClient())
            {
                httpClient.DefaultRequestHeaders.Add("Authentification", "abc123");
                Uri uri = new Uri("http://localhost:8080/post/" + subCategoryId);

                StringContent stringContent = new(JsonSerializer.Serialize(postToAdd, new JsonSerializerOptions()
                {
                    PropertyNameCaseInsensitive = true,
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                }), Encoding.UTF8, "application/json");
                HttpResponseMessage responseMessage =
                    await httpClient.PostAsync(uri, stringContent);

                content = await responseMessage.Content.ReadAsStringAsync();
                post = GetDeserialized<Post>(content);
            }
            //For adding image


            if (formDataContent != null)
            {
                Console.WriteLine("Ading image post ");
                Console.WriteLine(form.Headers.ToString());

                using (var httpClient1 = new HttpClient())
                {
                    httpClient1.DefaultRequestHeaders.Add("Authentification", "abc123");
                    Console.WriteLine(post.Id);
                    HttpResponseMessage responseForImage =
                        await httpClient1.PostAsync($"http://localhost:8080/uploadImage/{post.Id}", formDataContent);
                    // content = await responseForImage.Content.ReadAsStringAsync();
                    // Console.WriteLine(GetDeserialized<string>(content));
                   ;
                }
            }

            
            return post;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message + " " + e.StackTrace);
        }
    }


    public async Task<List<Category>> GetALlCategoriesAsync()
    {
        try
        {
            string client = await ClientAPI.getContent(Methods.Get, "/allCategories");
            List<Category> list = GetDeserialized<List<Category>>(client);
            return list;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }


    public async Task<List<Post>> GetAllPosts(int current)
    {
        try
        {
            string client = await ClientAPI.getContent(Methods.Get, $"/post/all/{current}");
            List<Post> list = GetDeserialized<List<Post>>(client);
            return list;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }

    public async Task<List<Post>> SearchPosts(string title, int current)
    {
        try
        {
            string client = await ClientAPI.getContent(Methods.Get, $"/search/{title}/{current}");
            List<Post> listFromServer = GetDeserialized<List<Post>>(client);
            return listFromServer;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }

    public async Task<List<Post>?> GetPostsBySubCategoryId(int subCategoryIdSelected, int current)
    {
        try
        {
            string client =
                await ClientAPI.getContent(Methods.Get, $"/bySubcategory/{subCategoryIdSelected}/{current}");
            List<Post> lisFromServer = GetDeserialized<List<Post>>(client);
            return lisFromServer;
        }
        catch (Exception e)
        {
            //   Console.WriteLine(e.Message);
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


    private T GetDeserialized<T>(string jsonFormat)
    {
        T obj = JsonSerializer.Deserialize<T>(jsonFormat, new JsonSerializerOptions()
        {
            PropertyNameCaseInsensitive = true
        }) !;
        return obj;
    }
}