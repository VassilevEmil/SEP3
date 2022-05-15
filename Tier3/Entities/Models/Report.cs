using System.ComponentModel.DataAnnotations.Schema;

namespace Entities.Models; 

public class Report 

{
// the follwing two props are for EFC use only
   
    [ForeignKey(nameof(Post))]
    public int PostId { get; set; }

    [ForeignKey(nameof(User))]
    public string  ReporterUsername { get; set; }

    public Post Post { get; set; }
    public User User { get; set; }


    public string Reason { get; set; }
}