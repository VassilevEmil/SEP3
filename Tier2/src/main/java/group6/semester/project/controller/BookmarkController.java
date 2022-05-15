package group6.semester.project.controller;

import group6.semester.project.model.Bookmark;
import group6.semester.project.model.Post;
import group6.semester.project.services.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookmarkController {

    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService =bookmarkService;
    }

    @PostMapping(value = "/bookmark")
    public ResponseEntity addBookmark(@RequestBody Bookmark bookmark) {
        try {
            bookmarkService.AddBookmark(bookmark);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/bookmark/{postId}/{userName}")
    public ResponseEntity removeBookmark(@PathVariable int postId, @PathVariable String userName) {
        try {
            bookmarkService.RemoveBookmark(postId,userName);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/bookmark/getAllPosts/{username}")
    public ResponseEntity<List<Post>> getListOfAllPostsByBookmark(@PathVariable String username) {
        var local = bookmarkService.getListOfBookedElements(username);
        return ResponseEntity.ok(local);
    }

}
