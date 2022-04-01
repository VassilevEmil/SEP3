using System.Runtime.InteropServices;
using System.Text;
using System.Text.Json;

namespace RESTClient;

public enum Methods
{
    Get,
    Post,
    Delete,
    Patch
}

/**
 * A modular class that will call 4 CRUD operation using API calls.
 * @author Adrian-Cristian Militaru
 */
public class ServerAPI
{
    private static string host = "http://localhost:8080";

    /**
     * 
     */
    public static async Task<string> getContent(Methods methods, string endpoint, [Optional] Object element)
    {
        using HttpClient client = new();
        HttpResponseMessage? response = new();
        string? content = String.Empty;
        StringContent? stringContent;

        switch (methods)
        {
            case Methods.Get:
                response = await client.GetAsync(host + endpoint);
                content = await response.Content.ReadAsStringAsync();

                if (!response.IsSuccessStatusCode)
                {
                    throw new Exception($"Error: {response.StatusCode}, {content}");
                }

                break;
            case Methods.Post:
                stringContent = new(JsonSerializer.Serialize(element), Encoding.UTF8, "application/json");
                response = await client.PostAsync(host + endpoint, stringContent);
                content = await response.Content.ReadAsStringAsync();
                if (!response.IsSuccessStatusCode)
                {
                    throw new Exception($"Error: {response.StatusCode}, {content}");
                }

                break;
            case Methods.Delete:
                response = await client.DeleteAsync(host + endpoint);
                content = await response.Content.ReadAsStringAsync();

                if (!response.IsSuccessStatusCode)
                {
                    throw new Exception($"Error: {response.StatusCode}, {content}");
                }

                break;
            case Methods.Patch:
                stringContent = new(JsonSerializer.Serialize(element), Encoding.UTF8, "application/json");
                response = await client.PatchAsync(host + endpoint, stringContent);
                content = await response.Content.ReadAsStringAsync();
                break;
        }

        return content;
    }
}