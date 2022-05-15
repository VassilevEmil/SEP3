package group6.semester.project.controller;

import group6.semester.project.model.Bookmark;
import group6.semester.project.model.Post;
import group6.semester.project.services.BookmarkService;
import group6.semester.project.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService =bookmarkService;
    }

    @PostMapping(value = "/bookmark")
    public ResponseEntity addPost(@RequestBody Bookmark bookmark) {
        try {
            bookmarkService.AddBookmark(bookmark);
            return ResponseEntity.ok("Bookmark added:" + bookmark.getPost().getId() + " by " + bookmark.getUser().getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/bookmark/{postId}/{userName}")
    public ResponseEntity addPost(@PathVariable int postId, @PathVariable String userName) {
        try {
            bookmarkService.RemoveBookmark(postId,userName);
            return ResponseEntity.ok("Bookmark removed:" + postId + userName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
