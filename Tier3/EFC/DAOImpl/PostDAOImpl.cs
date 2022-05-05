using Entities.Contracts;
using Entities.Models;

namespace EFC.DAOImpl; 

public class PostDAOImpl : IPostService {

    private readonly DbAccess _context;

    public PostDAOImpl(DbAccess context) {
        _context = context;
    }


    public Task<Post> AddPost(Post post) {

    }
}