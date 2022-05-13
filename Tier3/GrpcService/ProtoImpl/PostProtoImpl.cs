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

    public override async Task<ListOfPostObj> GetAllPosts(RequestModel request, ServerCallContext context) {
        int current = request.Current;
        var addPost = await _postService.GetAllPost(current);
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

    public override async Task<ListOfPostObj> SearchPosts(StringAndInteger request, ServerCallContext context) {
        String titleToSearch = request.String;
        int current = request.Current;
        List<Entities.Models.Post> searchedPosts = await _postService.SearchPosts(titleToSearch, current);
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

    
    public override async Task<ListOfPostObj> GetPostsBySubcategoryId(SubIdWithCurrent request, ServerCallContext context) {
        int current = request.Current;
        int subcategoryId = request.Id;

        
        List<Entities.Models.Post> postFromServer = await _postService.GetPostsBySubcategoryId(subcategoryId, current);
        ListOfPostObj obj = new ListOfPostObj() {
            List = {ConvertGRPC.GetRepeatedFieldOfPostFromListOfPosts(postFromServer)}
        };
        return obj;

    }

}