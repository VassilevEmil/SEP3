package group6.semester.project.grpcClient.comment;

import group6.semester.project.model.Comment;
import group6.semester.project.services.CommentService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

@Service
public class CommentClientImpl implements CommentClient {


    @Override
    public Comment addComment(int postId, Comment comment) {
        return null;
    }

    @Override
    public Comment deleteComment(int commentId) {
        return null;
    }
}
