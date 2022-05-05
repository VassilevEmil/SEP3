package group6.semester.project.grpcClient.post;

import GRPCService.PostGrpc;
import GRPCService.PostOuterClass;
import GRPCService.UserGrpc;
import group6.semester.project.grpcClient.GrpcConversionUtil;
import group6.semester.project.model.Post;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.internal.GrpcUtil;
import org.springframework.stereotype.Service;

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

        PostOuterClass.PostObj postObj = GrpcConversionUtil.getGrpcPostFromOurPost(post);
        PostOuterClass.IdWithInteger id = PostOuterClass.IdWithInteger.newBuilder().setId(subCategoryId).build();

        PostOuterClass.TransferPostWithSubcategoryId transferPostWithSubcategoryId = PostOuterClass.TransferPostWithSubcategoryId.newBuilder().setPostObj(postObj).setSubCategoryid(id).build();

        PostOuterClass.PostObj postObj1 = postBlockingStub.addPost(transferPostWithSubcategoryId);
        return GrpcConversionUtil.getPostFromGrpcPost(postObj1);
    }


}
