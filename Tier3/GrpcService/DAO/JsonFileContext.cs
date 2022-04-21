using System.Runtime.CompilerServices;
using System.Text.Json;
using Entities.Models;

namespace FileContext; 

public class JsonFileContext {
     private string filepath = "message.json";
     private ICollection<Message>? messages;

     public ICollection<Message> Messages {
         get {
             if (messages==null) {
                 LoadData();
             }

             return messages;
         }
     }

     private void LoadData() {
         string messageAsJson = File.ReadAllText(filepath);
         messages = JsonSerializer.Deserialize<List<Message>>(messageAsJson);
     }

     public JsonFileContext() {
          if (File.Exists(filepath)) {
              LoadData();
          }
          else {
              createFile();
          }
     }

     private async Task createFile() {
         messages = new List<Message>();
         Task.FromResult(SaveChangesAsync());
     }

     public async Task SaveChangesAsync() {
         string messagesAsJson = JsonSerializer.Serialize(messages, new JsonSerializerOptions() {
             WriteIndented = true,
             PropertyNameCaseInsensitive = true
         });
         await File.WriteAllTextAsync(filepath, messagesAsJson);
         messages = null;
     }
}