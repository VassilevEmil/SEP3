package group6.semester.project.services.SericeImpl;

import GRPCService.PostOuterClass;
import group6.semester.project.grpcClient.ConvertGrpc;
import group6.semester.project.grpcClient.bookmark.BookmarkClient;
import group6.semester.project.grpcClient.post.PostClient;
import group6.semester.project.model.Bookmark;
import group6.semester.project.model.Post;
import group6.semester.project.services.BookmarkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final PostClient postClient;
    private final BookmarkClient bookmarkClient;

    public BookmarkServiceImpl(PostClient postClient, BookmarkClient bookmarkClient) {
        this.postClient = postClient;
        this.bookmarkClient = bookmarkClient;
    }

    @Override
    public void AddBookmark(Bookmark bookmark) {
        try{
            bookmarkClient.AddBookmark(bookmark);
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void RemoveBookmark(int postId, String userName) {
        try {
            bookmarkClient.RemoveBookmark(postId,userName);
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Post> getListOfBookedElements(String userName) {
        try{
            return bookmarkClient.getListOfBookedElements(userName);
        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}
