package group6.semester.project.grpcClient.post;

import GRPCService.PostGrpc;
import GRPCService.PostOuterClass;

import group6.semester.project.grpcClient.ConvertGrpc;
import group6.semester.project.model.Post;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

import static group6.semester.project.grpcClient.ConvertGrpc.getPostFromGrpcPost;

@Service
public class PostGRPCClientImpl implements PostClient {

    private PostGrpc.PostBlockingStub postBlockingStub;

    /**
     * > If the postBlockingStub is null, create a new ManagedChannel and use it to create a new postBlockingStub
     *
     * @return A blocking stub for the Post service.
     */
    private PostGrpc.PostBlockingStub getPostBlockingStub() {
        if (postBlockingStub == null) {
            ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5250).usePlaintext().build();
            postBlockingStub = PostGrpc.newBlockingStub(managedChannel);
        }
        return postBlockingStub;
    }

    @Override
    public Post addPost(Post post, int subCategoryId) {

        PostOuterClass.PostObj postObj = ConvertGrpc.getGrpcPostFromOurPost(post);
        PostOuterClass.IdWithInteger id = PostOuterClass.IdWithInteger.newBuilder().setId(subCategoryId).build();

        PostOuterClass.TransferPostWithSubcategoryId transferPostWithSubcategoryId = PostOuterClass.TransferPostWithSubcategoryId.newBuilder().setPostObj(postObj).setIdWithInteger(id).build();
        PostOuterClass.PostObj postObj1 = null;
        try {
            postObj1 = getPostBlockingStub().addPost(transferPostWithSubcategoryId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            disposeStub();
        }
        return getPostFromGrpcPost(postObj1);
    }

    private void disposeStub() {
        postBlockingStub = null;
    }


}
