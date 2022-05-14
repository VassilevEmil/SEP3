using System.ComponentModel.DataAnnotations.Schema;

namespace Entities.Models; 

public class Report 

{

    [ForeignKey("Post")]
    public int PostId { get; set; }

    [ForeignKey("User")]
    public int ReporterUsername { get; set; }
    public string Reason { get; set; }
}