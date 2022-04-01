using System.Text.Json;
using Contracts;
using Entities.Models;

namespace RESTClient;

public class MessageHttpService : IHelloWorld
{
    public async Task<Message> returnMessage()
    {
        try
        {
            string content = await ServerAPI.getContent(Methods.Get,"/api/v1/helloworld");
        
            Message message = JsonSerializer.Deserialize<Message>(content, new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true
            })!;
            return message;
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }
}