using Entities.Contracts;
using Entities.Models;
using Grpc.Core;
using GRPCService.ProtoImpl.Util;

namespace GRPCService.ProtoImpl; 

public class CommentProtoImpl : comment.commentBase {

    private ICommentService _commentService;

    public CommentProtoImpl(ICommentService commentService) {
        _commentService = commentService;
    }

    public override async Task<CommentObj> AddComment(CommentObjAndInteger request, ServerCallContext context) {
        CommentObj commentObj = request.CommentObj;
        Comment commentToAdd = ConvertGRPC.GetCommentFromCommentObj(commentObj);
        int postId = request.PostId.Id;

        Comment addedCommentFromServer = await _commentService.AddComment(postId, commentToAdd);
        return ConvertGRPC.GetCommentObjFromComment(addedCommentFromServer);

    }

    public override async Task<CommentObj> DeleteComment(Integer request, ServerCallContext context) {
        int commentId = request.Id;
        Comment deletedComment =await _commentService.DeleteComment(commentId);
        return ConvertGRPC.GetCommentObjFromComment(deletedComment);
    }
}