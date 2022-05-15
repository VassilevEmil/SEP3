package group6.semester.project.grpcClient.bookmark;

import GRPCService.BookmarkGrpc;
import GRPCService.BookmarkOuterClass;
import GRPCService.PostGrpc;
import GRPCService.PostOuterClass;
import group6.semester.project.grpcClient.ConvertGrpc;
import group6.semester.project.grpcClient.ManagedChannelGetter;
import group6.semester.project.model.Bookmark;
import group6.semester.project.model.Post;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static group6.semester.project.grpcClient.ConvertGrpc.getPostFromGrpcPost;

@Service
public class BookmarkGRPCClientImpl implements BookmarkClient{

    private BookmarkGrpc.BookmarkBlockingStub bookmarkBlockingStub;

    private BookmarkGrpc.BookmarkBlockingStub getBookmarkBlockingStub() {
        if (bookmarkBlockingStub == null) {
            ManagedChannel managedChannel = ManagedChannelGetter.getManagedChannel();
            bookmarkBlockingStub = BookmarkGrpc.newBlockingStub(managedChannel);
        }
        return bookmarkBlockingStub;
    }

    @Override
    public void AddBookmark(Bookmark bookmark) {
        try {
            BookmarkOuterClass.BookmarkObj obj = ConvertGrpc.getGrpcBookmarkFromOurBookmark(bookmark);
            BookmarkOuterClass.EmptyBookMark message = null;
            getBookmarkBlockingStub().addBoomark(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            disposeStub();
        }
    }

    @Override
    public void RemoveBookmark(int postId, String userName) {
        try {
            BookmarkOuterClass.StringAndIntegerBookmark obj =  BookmarkOuterClass.StringAndIntegerBookmark.newBuilder().setCurrent(postId).setString(userName).build();
            getBookmarkBlockingStub().removeBookmark(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            disposeStub();
        }
    }

    @Override
    public List<Post> getListOfBookedElements(String userName) {
        try {
            BookmarkOuterClass.UserForBookMark obj =  BookmarkOuterClass.UserForBookMark.newBuilder().setUsername(userName).build();
            BookmarkOuterClass.ListOfPostsForBooking message = null;
            message = getBookmarkBlockingStub().getListOfPosts(obj);
            return ConvertGrpc.getListOfPostFromListOfGrpcPostObjects(message.getPostList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            disposeStub();
        }
    }

    private void disposeStub() {
        bookmarkBlockingStub = null;
    }
}
