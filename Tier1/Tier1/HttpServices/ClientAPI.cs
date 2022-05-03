using System.Runtime.InteropServices;
using System.Text;
using System.Text.Json;

namespace HttpServices;


//Modular class calling 4 CRUD operations
public enum Methods
{
    Get,
    Post,
    Delete,
    Patch
}

public class ClientAPI
{
    private static string host = "http://localhost:8080";
    
      public static async Task<string> getContent(Methods methods,string endpoint, [Optional] Object element)
    {
        using HttpClient client = new();
        HttpResponseMessage? response = new();
        string? content=String.Empty;
        StringContent? stringContent;
        
        switch (methods)
        {
            case Methods.Get:
                response = await client.GetAsync(host+endpoint);
                content = await response.Content.ReadAsStringAsync();

                if (!response.IsSuccessStatusCode)
                {
                    Console.Write(content);
                    throw new Exception($"{content}");
                }

                break;
            case Methods.Post:
                
                stringContent = new(JsonSerializer.Serialize(element, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                }), Encoding.UTF8, "application/json");
                response = await client.PostAsync(host + endpoint, stringContent);
                content = await response.Content.ReadAsStringAsync();
                if (!response.IsSuccessStatusCode)
                {
                    throw new Exception($"Error: {response.StatusCode}, {content}");
                }
                break;
            case Methods.Delete:
                response = await client.DeleteAsync(host+endpoint);
                content = await response.Content.ReadAsStringAsync();

                if (!response.IsSuccessStatusCode)
                {
                    throw new Exception($"Error: {response.StatusCode}, {content}");
                }
                break;
            case Methods.Patch:
                stringContent = new(JsonSerializer.Serialize(element, new JsonSerializerOptions()
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                }), Encoding.UTF8, "application/json");
                response = await client.PatchAsync(host + endpoint, stringContent);
                content = await response.Content.ReadAsStringAsync();
                if (!response.IsSuccessStatusCode)
                {
                    throw new Exception($"Error: {response.StatusCode}, {content}");
                }
                break;
        }

        return content;
    }
}