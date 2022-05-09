
namespace Entities.Models; 

public class Post
{
    public int Id { get; set; }
    public string Title { get; set; }
    public string Description { get; set; }
    public Date DateCreated { get; set; }
    public int? Price { get; set; }
    public string? Address { get; set; }
    public string Condition { get; set; }
    public string? PhoneNumber { get; set; }
    public string? Email { get; set; }
    public ICollection<Image> Images { get; set; }
    public User Writer { get; set; }
    

}