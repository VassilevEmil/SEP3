package group6.semester.project.grpcClient.post;

import group6.semester.project.model.Post;
import org.springframework.stereotype.Service;

@Service
public interface PostClient {
    Post addPost(Post post);
}
