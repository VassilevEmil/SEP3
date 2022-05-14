package group6.semester.project.services.SericeImpl;

import group6.semester.project.grpcClient.comment.CommentClient;
import group6.semester.project.model.Comment;
import group6.semester.project.services.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentClient commentClient;

    public CommentServiceImpl(CommentClient commentClient) {
        this.commentClient = commentClient;
    }

    @Override
    public Comment addComment(int postId, Comment comment) {
        return commentClient.addComment(postId, comment);
    }
}
