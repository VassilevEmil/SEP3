using System.ComponentModel.DataAnnotations;

namespace Entities.Models; 

public class Image {
    [Key]
    public int Id { get; set; }
    public string Href { get; set; }
    
}