package group6.semester.project.grpcClient.comment;


import group6.semester.project.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentClient {
    Comment addComment(int postId, Comment comment);

    Comment deleteComment(int commentId);
}
