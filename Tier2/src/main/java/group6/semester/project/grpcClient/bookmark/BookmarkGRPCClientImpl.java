package group6.semester.project.grpcClient.bookmark;

import GRPCService.BookmarkGrpc;
import GRPCService.BookmarkOuterClass;
import GRPCService.PostGrpc;
import GRPCService.PostOuterClass;
import group6.semester.project.grpcClient.ConvertGrpc;
import group6.semester.project.grpcClient.ManagedChannelGetter;
import group6.semester.project.model.Bookmark;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

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
        BookmarkOuterClass.BookmarkObj obj = ConvertGrpc.getGrpcBookmarkFromOurBookmark(bookmark);
        BookmarkOuterClass.Message message = null;
        try {
            System.out.println("At the add post");
            message = getBookmarkBlockingStub().addBoomark(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            disposeStub();
        }
    }

    @Override
    public void RemoveBookmark(int postId, String userName) {

    }

    private void disposeStub() {
        bookmarkBlockingStub = null;
    }
}
