package group6.semester.project.controller;

import group6.semester.project.model.Post;
import group6.semester.project.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/post{subForumId:int}")

    public ResponseEntity addPost(@RequestBody Post post, @PathVariable int subForumId){

        try {
            Post addedPost = postService.addPost(post, subForumId);
            return ResponseEntity.ok(addedPost);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }


    }



}
