using Entities.Models;
using Microsoft.EntityFrameworkCore;

namespace EFC;

public class DBContext : DbContext
{
    public DbSet<User> Users { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        //optionsBuilder.UseNpgsql(@"Data Source = ..\EFCDataAccess\Forum.db");
        optionsBuilder.UseSqlite(@"Data Source  = ..\EFC\user.db");
        optionsBuilder.EnableSensitiveDataLogging();
    }

   
}