/**
 * It converts objects from the gRPC service to our objects and vice versa
 */
package group6.semester.project.grpcClient;

import GRPCService.CategoryOuterClass;
import GRPCService.PostOuterClass;
import GRPCService.UserOuterClass;
import com.google.type.DateTime;
import group6.semester.project.model.*;

import java.util.ArrayList;
import java.util.List;

public class ConvertGrpc {

    /**
     * This function takes a User object and converts it into a GRPC UserObj object
     *
     * @param user The user object that we want to convert to a gRPC object.
     * @return A UserOuterClass.UserObj object
     */
    public static UserOuterClass.UserObj getGrpcUserFromUser(User user) {
        UserOuterClass.UserObj userObj = UserOuterClass.UserObj.newBuilder().setFirstName(
                user.getFirstName()).setLastName(user.getLastName()).setPassword(
                user.getPassword()).setUsername(user.getUsername()).setRole(
                user.getRole()).build();
        return userObj;
    }

    /**
     * * Returns the gRPC user  object from user model obj
     *
     * @param userObj
     * @return
     */

    public static User getUserFromGrpcUser(UserOuterClass.UserObj userObj) {
        User user = new User();
        user.setFirstName(userObj.getFirstName());
        user.setLastName(userObj.getLastName());
        user.setPassword(userObj.getPassword());
        user.setUsername(userObj.getUsername());
        user.setRole(userObj.getRole());
        return user;
    }


    /**
     * It converts a grpc Post object to a Post object.
     *
     * @param postObj the post object from the gRPC server
     * @return A Post object
     */
    public static Post getPostFromGrpcPost(PostOuterClass.PostObj postObj) {
        Post post = new Post();
        post.setId(postObj.getId());
        post.setAddress(postObj.getAddress());
        post.setCondition(postObj.getCondition());
        post.setPhoneNumber(postObj.getPhoneNumber());
        post.setDescription(postObj.getDescription());
        post.setEmail(postObj.getEmail());
        post.setWriter(getUserFromGrpcUser(postObj.getWriter()));
        post.setPrice(postObj.getPrice());
        post.setTitle(postObj.getTitle());
        post.setImages(getListOfImageFromListOfGrpcImages(postObj.getImagesList()));
        post.setDateCreated( null);
        return post;
    }

    /**
     * This function takes a Post object and returns a PostObj object
     *
     * @param post the post object that we want to convert to a grpc post object
     * @return A PostOuterClass.PostObj object.
     */
    public static PostOuterClass.PostObj getGrpcPostFromOurPost(Post post) {
        PostOuterClass.PostObj postObj = PostOuterClass.PostObj.newBuilder()
                .setId(post.getId())
                .setAddress(post.getAddress()).setCondition(post.getCondition())
                .setDateCreated(getDateCreatedFromYearMonthDay(post.getDateCreated()))
                .addAllComments(getListOfGRPCCommentsFromOurListOfComments(new ArrayList<>()))
                .setTitle(post.getTitle()).setPrice(post.getPrice())
                . setDescription(post.getDescription())
                .setPhoneNumber(post.getPhoneNumber())
                .setEmail(post.getEmail())
                .addAllImages(getListOfGRPCImageFromListOfImage(post.getImages()))
                .setWriter(getGrpcUserFromUser(post.getWriter()))
                .setPrice(post.getPrice())
                .build();
        return postObj;


    }

    public static PostOuterClass.DateCreated getDateCreatedFromYearMonthDay(Date date){
        PostOuterClass.DateCreated dateCreated = PostOuterClass.DateCreated.newBuilder().setDay(date.getDay()).setMonth(date.getMonth()).setYear(date.getYear()).build();
        return dateCreated;


    }


    /**
     * Converts the list of grpc posts to the list of our posts..
     *
     * @param list
     * @return
     */
    public static List<Post> getListOfPostFromListOfGrpcPostObjects(List<PostOuterClass.PostObj> list) {
        List<Post> posts = new ArrayList<>();
        for (PostOuterClass.PostObj i : list
        ) {
            posts.add(getPostFromGrpcPost(i));
        }

        return posts;
    }

    /**
     * Converts grpc image to our image
     *
     * @param imageObj
     * @return
     */

    public static Image getImageFromGRPCImage(GRPCService.Image.ImageObj imageObj) {
        Image image = new Image();
        image.setId(imageObj.getId());
        image.setHref(imageObj.getHref());
        return image;
    }

    /**
     * Converts the list of grpc image to our image obj
     *
     * @param list
     * @return
     */
    public static List<Image> getListOfImageFromListOfGrpcImages(List<GRPCService.Image.ImageObj> list) {
        List<Image> images = new ArrayList<>();
        for (GRPCService.Image.ImageObj imageObj : list
        ) {
            images.add(getImageFromGRPCImage(imageObj));
        }
        return images;
    }


    /**
     * It converts an Image object to a GRPC Image object.
     *
     * @param image The image object that we want to convert to a gRPC object.
     * @return A GRPCService.Image.ImageObj object.
     */
    public static GRPCService.Image.ImageObj getGrpcImageFromImage(Image image) {
        GRPCService.Image.ImageObj imageObj = GRPCService.Image.ImageObj.newBuilder().setId(image.getId()).setHref(image.getHref()).build();
        return imageObj;
    }


    /**
     * It converts a list of Image objects to a list of GRPCService.Image.ImageObj objects.
     *
     * @param list List of Image objects
     * @return A list of GRPCService.Image.ImageObj
     */
    public static List<GRPCService.Image.ImageObj> getListOfGRPCImageFromListOfImage(List<Image> list) {
        List<GRPCService.Image.ImageObj> imageObjList = new ArrayList<>();
        for (Image img : list
        ) {
            imageObjList.add(getGrpcImageFromImage(img));
        }
        return imageObjList;
    }


    /**
     * It takes a GRPC Comment object and converts it into a Comment object
     *
     * @param commentObj The comment object that is being converted to a Comment object.
     * @return A Comment object
     */
    public static Comment getCommentFromGrpcComment(GRPCService.Comment.CommentObj commentObj) {
        Comment comment = new Comment();
        comment.setWriter(getUserFromGrpcUser(commentObj.getWriter()));
        comment.setBody(commentObj.getBody());
        comment.setId(commentObj.getId());
        return comment;
    }

    /**
     * It converts a Comment object to a CommentObj object.
     *
     * @param comment The comment object that we want to convert to a gRPC object.
     * @return A CommentObj object.
     */
    public static GRPCService.Comment.CommentObj getGrpcCommentFromOurComment(Comment comment){
        GRPCService.Comment.CommentObj commentObj = GRPCService.Comment.CommentObj.newBuilder().setId(comment.getId())
                .setWriter(getGrpcUserFromUser(comment.getWriter())).setBody(comment.getBody()).build();
        return commentObj;
    }

    /**
     * It takes a list of our Comment objects and returns a list of GRPCService.Comment.CommentObj objects
     *
     * @param list The list of comments that you want to convert to a list of GRPC comments.
     * @return A list of GRPCService.Comment.CommentObj
     */
    public static List<GRPCService.Comment.CommentObj> getListOfGRPCCommentsFromOurListOfComments(List<Comment> list)
    {
        List<GRPCService.Comment.CommentObj> commentObjs = new ArrayList<>();
        for (Comment i : list) {
            commentObjs.add(getGrpcCommentFromOurComment(i));
        }
        return commentObjs;
    }


    /**
     * It converts a list of GRPC comments to a list of comments.
     *
     * @param list the list of comments from the gRPC service
     * @return A list of comments
     */
    public static List<Comment> getListOfCommentFromGrpcListOfComments(List<GRPCService.Comment.CommentObj> list) {
        List<Comment> comments = new ArrayList<>();
        for (GRPCService.Comment.CommentObj commentObj : list
        ) {
            comments.add(getCommentFromGrpcComment(commentObj));
        }
        return comments;
    }

    /**
     * It takes a GRPCService.Category.CategoryObj object and returns a Category object
     *
     * @param categoryObj The GRPC object that is received from the server.
     * @return A Category object
     */
    public static Category getCategoryFromGrpcCategory(GRPCService.CategoryOuterClass.CategoryObj categoryObj) {
        Category category = new Category();
        category.setId(categoryObj.getId());
        category.setName(categoryObj.getName());
        category.setSubcategories(getListOfSubCategoryFromListOfGrpcSubcatgeories(categoryObj.getSubCategoriesList()));
        return category;
    }

    public static List<Category> getListOfCategoryFromCategory(List<CategoryOuterClass.CategoryObj> categoryObjList){
        List<Category> categories = new ArrayList<>();
        for (CategoryOuterClass.CategoryObj i:categoryObjList
             ) {
            categories.add(getCategoryFromGrpcCategory(i));

        }
        return categories;
    }


    /**
     * It takes a GRPCService.Subcategory.SubcategoryObj object and returns a Subcategory object
     *
     * @param subcategoryObj This is the object that is received from the server.
     * @return A list of posts
     */
    public static Subcategory getSubCategoriesFromGrpcSubCategories(GRPCService.Subcategory.SubcategoryObj subcategoryObj) {
        Subcategory subcategory = new Subcategory();
        subcategory.setId(subcategoryObj.getId());
        subcategory.setName(subcategoryObj.getName());
        subcategory.setPosts(getListOfPostFromListOfGrpcPostObjects(subcategoryObj.getPostsList()));
        return subcategory;

    }

    /**
     * It converts a list of GRPCService.Subcategory.SubcategoryObj to a list of Subcategory.
     *
     * @param list List of GRPCService.Subcategory.SubcategoryObj
     * @return A list of subcategories
     */
    public static List<Subcategory> getListOfSubCategoryFromListOfGrpcSubcatgeories(List<GRPCService.Subcategory.SubcategoryObj> list) {
        List<Subcategory> subcategories = new ArrayList<>();
        for (GRPCService.Subcategory.SubcategoryObj i : list
        ) {
            subcategories.add(getSubCategoriesFromGrpcSubCategories(i));

        }
        return subcategories;
    }


}
