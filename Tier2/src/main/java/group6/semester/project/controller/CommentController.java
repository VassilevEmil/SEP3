package group6.semester.project.controller;

import group6.semester.project.model.Comment;
import group6.semester.project.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping(value = "/comments/{postId}")
    public ResponseEntity addComment(@PathVariable int postId, @RequestBody Comment comment) {
        try {
            Comment addedComment = commentService.addComment(postId, comment);
            return ResponseEntity.ok(addedComment);
        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping(value = "/comments/{commentId}")
    public ResponseEntity deleteComment(@PathVariable int commentId) {
        try {
            Comment comment = commentService.deleteComment(commentId);
            return ResponseEntity.ok(comment);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
