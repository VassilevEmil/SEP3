package group6.semester.project.services;

import group6.semester.project.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment addComment(int postId, Comment comment);

    Comment deleteComment(int commentId);
}
