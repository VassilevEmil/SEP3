using Entities.Models;

namespace Contracts;

public interface IHelloWorld
{
    public Task<Message> returnMessage();
}