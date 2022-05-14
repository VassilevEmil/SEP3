namespace Entities.Models; 

public class Comment {

    public int Id { get; set; }
    public string Body { get; set; }
    public Date DateCreated { get; set; }
    public User Writer { get; set; }
}