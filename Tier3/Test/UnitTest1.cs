using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using EFC.DAOImpl;
using Entities.Models;
using NUnit.Framework;
using static EFC.DAOImpl.PostDAOImpl;

namespace Test;

public class Tests
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void GetingPostByUsername()
    {
        string userName = "sachin123";
        ICollection<Post>? a =  new PostDAOImpl().GetPostByUsername(userName).Result;
        foreach (var VARIABLE in a)
        {
            Console.WriteLine(VARIABLE.Subcategory.Name);
            Console.WriteLine(VARIABLE.Subcategory.Category.Name);
            
        }
        
    }
}