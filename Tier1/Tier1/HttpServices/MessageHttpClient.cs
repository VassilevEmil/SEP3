using System.Text;
using System.Text.Json;
using Contracts;
using Entities.Models;

namespace HttpServices; 

public class MessageHttpClient : IMessageService {
    public async Task<Message> SendMessageAsync(Message message) {
        using HttpClient client = new HttpClient();
        string messageAsJson = JsonSerializer.Serialize(message,new JsonSerializerOptions() {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        });
        StringContent content = new StringContent(messageAsJson, Encoding.UTF8, "application/json");
        HttpResponseMessage responseMessage = await client.PostAsync("http://localhost:8080/message", content);
        string responseContent =
            await GetResponseContentFromResponseMessageAndThrowAppropriateException(responseMessage);
        Message messageFromServer = GetDeserialized<Message>(responseContent);
        return messageFromServer;
    }

    public async Task<Message> GetMessageByIdAsync(int id) {

        using HttpClient client = new HttpClient();
        HttpResponseMessage responseMessage = await client.GetAsync($"http://localhost:8080/message/{id}");
        string responseContent =
            await GetResponseContentFromResponseMessageAndThrowAppropriateException(responseMessage);
        Message messageFromServer  = GetDeserialized<Message>(responseContent);
        return messageFromServer;

    }
    private T GetDeserialized<T>(string jsonFormat) {
        T obj = JsonSerializer.Deserialize<T>(jsonFormat, new JsonSerializerOptions() {
            PropertyNameCaseInsensitive = true
        }) !;
        return obj;
    }

    private async Task<string> GetResponseContentFromResponseMessageAndThrowAppropriateException(
        HttpResponseMessage responseMessage) {
        string responseContent = await responseMessage.Content.ReadAsStringAsync();
        if (!responseMessage.IsSuccessStatusCode) {
            throw new Exception($"Error :{responseMessage.StatusCode}, {responseContent}");
        }

        return responseContent;
    }
}