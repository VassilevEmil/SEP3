using Entities.Contracts;
using Entities.Models;
using Grpc.Core;
using GRPCService.ProtoImpl.Util;


namespace GRPCService.ProtoImpl;

public class PostProtoImpl : Post.PostBase {
    private IPostService _postService;

    public PostProtoImpl(IPostService postService) {
        _postService = postService;
    }

    public override async Task<ListOfPostObj> GetAllPosts(RequestModel request, ServerCallContext context)
    {
        var addPost = await _postService.GetAllPost();
        return ConvertGRPC.ConvertListPostToObj(addPost);
    }

    public override async Task<PostObj> AddPost(TransferPostWithSubcategoryId request, ServerCallContext context) {
        PostObj postObj = request.PostObj;
        IdWithInteger idWith = request.IdWithInteger;

        Entities.Models.Post post = ConvertGRPC.ConvertPostObjToPost(postObj);
        int subCategoryId = idWith.Id;

        Console.Write(post.Title);
        DateTime dateTime = new DateTime();

        var addPost = await _postService.AddPost(subCategoryId, post);
        return ConvertGRPC.ConvertPostToPostObj(addPost);
    }

    public override async Task<ListOfPostObj> SearchPosts(OnlyString request, ServerCallContext context) {
        String titleToSearch = request.String;
        List<Entities.Models.Post> searchedPosts = await _postService.SearchPosts(titleToSearch);
        ListOfPostObj listOfPostObj = new ListOfPostObj() {
            List = {ConvertGRPC.GetRepeatedFieldOfPostFromListOfPosts(searchedPosts)}
        };
        return listOfPostObj;
    }

    public override async Task<PostObj> GetPostDetails(IdWithInteger Id, ServerCallContext context)
    {
        var  post = await _postService.GetPostDetails(Id.Id);
        return ConvertGRPC.ConvertPostToPostObj(post);
    }
}