using System.ComponentModel.DataAnnotations;

namespace Entities.Models; 

public class User 
{
    [Key]
    public string Username { get; set; }
    public string Password { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public string? Role { get; set; }

    public ICollection<Post>? Posts  { get; set; }

}