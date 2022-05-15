using Entities.Models;
using Microsoft.EntityFrameworkCore;

namespace EFC;

public class DbAccess : DbContext
{
    public DbSet<User> Users { get; set; }
    public DbSet<Post> Posts { get; set; }
    public DbSet<Category> Categories { get; set; }
    public DbSet<Subcategory> Subcategories { get; set; }
    public DbSet<Image> Images { get; set; }
    public DbSet<Bookmark> Bookmarks { get; set; }
    public DbSet<Report> Reports { get; set; }

    public DbSet<Comment> Comments { get; set; }


    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        //https://api.elephantsql.com/console/75da4502-36f5-47cf-b29b-2bd6d5301618/details
        optionsBuilder.UseNpgsql(@"Host=balarama.db.elephantsql.com;Database=ubptppqb;Username=ubptppqb;Password=DlaXSF8Wa8ZJo5vV06domqvVCVivHLsc");
        optionsBuilder.EnableSensitiveDataLogging();
    }


    protected override void OnModelCreating(ModelBuilder modelBuilder) {
        modelBuilder.Entity<Report>().HasKey(report => new {report.PostId, report.ReporterUsername});
        modelBuilder.Entity<Bookmark>().HasKey(post => new {post.PostId, post.Username});

    }
}