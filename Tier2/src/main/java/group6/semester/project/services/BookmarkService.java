package group6.semester.project.services;

import group6.semester.project.model.Bookmark;
import group6.semester.project.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookmarkService {
    void AddBookmark(Bookmark bookmark);
    void RemoveBookmark(int postId, String userName);
}
