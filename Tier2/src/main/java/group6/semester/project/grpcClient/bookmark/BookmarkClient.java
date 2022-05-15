package group6.semester.project.grpcClient.bookmark;

import group6.semester.project.model.Bookmark;
import group6.semester.project.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookmarkClient {
    void AddBookmark(Bookmark bookmark);
    void RemoveBookmark(int postId, String userName);

    List<Post> getListOfBookedElements(String userName);
}
