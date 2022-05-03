
namespace Entities.Models; 

public class Subcategory {
    
    public int Id { get; set; }
    public string Name { get; set; }
    public ICollection<Post> Posts { get; set; }
    public Category Category { get; set; }
}