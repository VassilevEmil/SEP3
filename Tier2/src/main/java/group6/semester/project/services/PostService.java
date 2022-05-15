package group6.semester.project.services;

import group6.semester.project.model.Category;
import group6.semester.project.model.Post;
import group6.semester.project.model.Subcategory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface PostService {
    Post addPost(Post post, int subcategoryId);

    List<Category> getAllCategories();

    List<Post> searchPosts(String title,int current);

    List<Post> getAllPosts(int current);

    Post getPostDetails(int Id);

    List<Post> getPostsBySubcategories(int subCategoryIdSelected, int current);

    void addImage(MultipartFile file, int postId) throws IOException;
}
