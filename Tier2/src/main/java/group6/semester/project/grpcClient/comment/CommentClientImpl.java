package group6.semester.project.grpcClient.comment;

import GRPCService.PostGrpc;
import GRPCService.commentGrpc;
import group6.semester.project.grpcClient.ConvertGrpc;
import group6.semester.project.grpcClient.ManagedChannelGetter;
import group6.semester.project.model.Comment;
import group6.semester.project.services.CommentService;
import io.grpc.ManagedChannel;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

@Service
public class CommentClientImpl implements CommentClient {


    private commentGrpc.commentBlockingStub commentBlockingStub;

    /**
     * If the commentBlockingStub is null, then create a new ManagedChannel and a new commentBlockingStub
     *
     * @return A blocking stub.
     */
    private commentGrpc.commentBlockingStub getCommentBlockingStub() {
        if (commentBlockingStub == null) {
            ManagedChannel managedChannel = ManagedChannelGetter.getManagedChannel();
            commentBlockingStub = commentGrpc.newBlockingStub(managedChannel);
        }
        return commentBlockingStub;
    }


    @Override
    public Comment addComment(int postId, Comment comment) {
        GRPCService.Comment.CommentObj commentObj = ConvertGrpc.getCommentObjFromComment(comment);
        GRPCService.Comment.CommentObjAndInteger commentObjAndInteger = GRPCService.Comment.CommentObjAndInteger.newBuilder()
                .setCommentObj(commentObj)
                .setPostId(GRPCService.Comment.Integer.newBuilder().setId(postId).build())
                .build();
        GRPCService.Comment.CommentObj commentObjFromServer = getCommentBlockingStub().addComment(commentObjAndInteger);
        return ConvertGrpc.getCommentFromGRPCCommentObj(commentObjFromServer);
    }

    @Override
    public Comment deleteComment(int commentId) {
        return null;
    }
}
