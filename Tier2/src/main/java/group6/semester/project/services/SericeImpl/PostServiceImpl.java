package group6.semester.project.services.SericeImpl;


import group6.semester.project.grpcClient.fileUpload.ImageGrpcImpl;
import group6.semester.project.grpcClient.post.PostClient;
import group6.semester.project.model.Category;
import group6.semester.project.model.Post;
import group6.semester.project.services.PostService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostClient postClient ;
    private final ImageGrpcImpl imageGrpc;

    public PostServiceImpl(PostClient postClient,ImageGrpcImpl imageGrpc) {
        this.postClient = postClient;
        this.imageGrpc = imageGrpc;
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

        System.out.println("At post service "+post.getDescription()+ "title :"+post.getTitle());
        return postClient.addPost(post, subCategoryId);
    }

    @Override
    public List<Category> getAllCategories() {
        return postClient.getAllCategories();
    }

    @Override
    public List<Post> searchPosts(String title, int current) {
        return postClient.searchPosts(title,current);
    }

    @Override
    public List<Post> getAllPosts(int current) {
        return postClient.getAllPosts(current);
    }

    @Override
    public Post getPostDetails(int Id) {
        return postClient.getPostDetails(Id);
    }

    @Override
    public List<Post> getPostsBySubcategories(int subCategoryIdSelected, int current) {

        return postClient.getPostBySubcategoryId(subCategoryIdSelected, current);
    }

    @Override public void addImage(MultipartFile file, int postId)
        throws IOException
    {
        imageGrpc.uploadImage(file,postId);
    }

}
