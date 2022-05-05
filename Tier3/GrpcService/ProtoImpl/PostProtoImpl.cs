using Entities.Contracts;
using Grpc.Core;
using GRPCService.ProtoImpl.Util;


namespace GRPCService.ProtoImpl;

public class PostProtoImpl : Post.PostBase {
    private IPostService _postService;

    public PostProtoImpl(IPostService postService) {
        _postService = postService;
    }

    
    public async override Task<PostObj> AddPost(PostObj request, ServerCallContext context) {
        Entities.Models.Post post = ConvertGRPC.ConvertPostObjToPost(request);
        Entities.Models.Post postFromServer=await _postService.AddPost(post);
       return ConvertGRPC.ConvertPostToPostObj(postFromServer);
    }

 


  

  
}