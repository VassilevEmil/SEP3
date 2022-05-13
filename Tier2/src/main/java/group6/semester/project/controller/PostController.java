package group6.semester.project.controller;

import group6.semester.project.model.Category;
import group6.semester.project.model.Post;
import group6.semester.project.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/post/{subCategoryId}")
    public ResponseEntity addPost(@RequestBody Post post, @PathVariable int subCategoryId) {

        try {
            System.out.println(post);
            Post addedPost = postService.addPost(post, subCategoryId);
            return ResponseEntity.ok(addedPost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/post/all/{current}")
    public ResponseEntity<List<Post>> getAllPosts(@PathVariable int current) throws RuntimeException {

        System.out.println("Get all posts is called");
        List<Post> posts = postService.getAllPosts(current);
        return ResponseEntity.ok(posts);

    }

    @GetMapping(value = "/allCategories")
    @ResponseBody
    public ResponseEntity getAllCategories() {
        try {
            List<Category> categories = postService.getAllCategories();
            return ResponseEntity.ok(categories);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping(value = "/search/{title}/{current}")
    @ResponseBody
    public ResponseEntity searchPosts(@PathVariable String title, @PathVariable int current) {
        try {
            List<Post> posts = postService.searchPosts(title, current);
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping(value = "PostDetails/{Id}")
    @ResponseBody
    public ResponseEntity getPostDetails(@PathVariable int Id) {
        try {
            Post post = postService.getPostDetails(Id);
            return ResponseEntity.ok(post);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/bySubcategory/{subCategoryIdSelected}/{current}")
    @ResponseBody
    public ResponseEntity getPostsBySubcategoryId(@PathVariable int subCategoryIdSelected, @PathVariable int current){


        try {
            List<Post> list = postService.getPostsBySubcategories(subCategoryIdSelected, current);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }

    }


}
