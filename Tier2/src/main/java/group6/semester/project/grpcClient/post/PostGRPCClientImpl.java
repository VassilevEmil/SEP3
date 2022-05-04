package group6.semester.project.grpcClient.post;

import GRPCService.PostGrpc;
import GRPCService.PostOuterClass;
import GRPCService.UserGrpc;
import group6.semester.project.model.Post;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class PostGRPCClientImpl implements PostClient{

    private PostGrpc.PostBlockingStub postBlockingStub;

    public PostGrpc.PostBlockingStub getPostBlockingStub() {
        if (postBlockingStub==null){
            ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5250).usePlaintext().build();
            postBlockingStub = PostGrpc.newBlockingStub(managedChannel);
        }
        return postBlockingStub;
    }

    @Override
    public Post addPost(Post post) {
        return null;
    }

    private PostOuterClass.PostObj getGrpcPostFromMyPost(Post post){
return null;
    }
}
