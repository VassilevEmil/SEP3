using System.Collections.Specialized;
using Contracts;
using Entities.Models;
using HttpServices;

namespace UNITtests;
using NUnit.Framework;

public class BookmarkJUnit
{
    protected IBookmarkService _bookmarkService;
    protected IUserService _userService;
    protected IPostService _postService;
    
    [SetUp]
    public virtual void Setup()
    {
        _bookmarkService = new BookmarkHttpClient();
        _userService = new UserHttpClient();
        _postService = new PostHttpClient();
    }

    [Test]
    public async virtual Task TestBookPost()
    {
        try
        {
            Bookmark bookmark = new Bookmark()
            {
                //the id of the post may depend base on what is DB
                Post = await _postService.GetPostDetails(11),
                //the id of the user may depend base on what is DB
                User = await _userService.GetUserAsync("adrian1234")
            };
            await _bookmarkService.AddBookmark(bookmark);
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }

    [Test]
    public async Task TestaddBookAlreadyExist()
    {
        
            Bookmark bookmark = new Bookmark()
            {
                //the id of the post may depend base on what is DB
                Post = await _postService.GetPostDetails(11),
                //the id of the user may depend base on what is DB
                User = await _userService.GetUserAsync("adrian1234")
            };
            
            Assert.ThrowsAsync<Exception>((async () => await _bookmarkService.AddBookmark(bookmark)));
        
    }

    [Test]
    public async virtual Task getListOfPostsThatAreBookedByAUser()
    {
        try
        {
            //the id of the user may depend base on what is DB
            List<Post> listOfBookedElements= await _bookmarkService.getListOfBookedElements("adrian1234");

            Console.WriteLine("------------");
            foreach (var item in listOfBookedElements)
            {
                Console.WriteLine(item.Title);
            }

        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }
    
    
    [Test]
    public async virtual Task TestRemoveBookPost()
    {
        try
        {
            Post test = new Post();
            Bookmark bookmark = new Bookmark()
            {
                //the id of the post may depend base on what is DB
                Post = await _postService.GetPostDetails(11),
                //the id of the user may depend base on what is DB
                User = await _userService.GetUserAsync("adrian1234")
            };
            _bookmarkService.RemoveBookmark(bookmark);
        }
        catch (Exception e)
        {
            throw new Exception(e.Message);
        }
    }
    
    
    
}