using System.ComponentModel.DataAnnotations;

namespace Entities.Models; 

public class Category {
    [Key]
    public int Id { get; set; }

    public string Name { get; set; }
    public ICollection<Subcategory> Subcategories { get; set; }

}