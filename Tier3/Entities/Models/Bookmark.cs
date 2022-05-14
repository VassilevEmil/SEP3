using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Entities.Models; 

public class Bookmark {


    // Following two props are just for EFC use
    [ForeignKey(nameof(User))]
    public string Username { get; set; }

    [ForeignKey(nameof(Post))]
    public int  PostId { get; set; }

    public User User { get; set; }

    public Post Post { get; set; }

}