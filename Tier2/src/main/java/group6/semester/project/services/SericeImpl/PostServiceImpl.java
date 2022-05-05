package group6.semester.project.services.SericeImpl;

import GRPCService.PostOuterClass;
import group6.semester.project.grpcClient.GrpcConversionUtil;
import group6.semester.project.grpcClient.post.PostClient;
import group6.semester.project.model.Post;
import group6.semester.project.services.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostClient postClient ;

    public PostServiceImpl(PostClient postClient) {
        this.postClient = postClient;
    }

    /**
     * > The function adds a post to the database
     *
     * @param post the post object to be added.
     * @return A Post object.
     */
    @Override
    public Post addPost(Post post, int subCategoryId) {

//        PostOuterClass.PostObj postObj = GrpcConversionUtil.getGrpcPostFromOurPost(post);
//        PostOuterClass.TransferPostWithSubcategoryId transferPostWithSubcategoryId = PostOuterClass.TransferPostWithSubcategoryId.newBuilder().setPostObj(postObj).
//       setSubCategoryid(subCategoryId) .build()
        //todo all the business logics here...
        return postClient.addPost(post, subCategoryId);
    }
}