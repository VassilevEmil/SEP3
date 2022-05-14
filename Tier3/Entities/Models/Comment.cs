using System.ComponentModel.DataAnnotations;

namespace Entities.Models; 

public class Comment {
    [Key]
    public int Id { get; set; }


    public Post Post { get; set; }
    public string Body { get; set; }
    public DateOnly DateCreated { get; set; }
    public User Writer { get; set; }

}