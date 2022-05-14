using System.ComponentModel.DataAnnotations;

namespace Entities.Models; 

public class Bookmark {

    [Key]
    public int Id { get; set; }
    public User User { get; set; }
    public Post Post { get; set; }

}