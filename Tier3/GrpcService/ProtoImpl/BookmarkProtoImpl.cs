
using Entities.Contracts;
using Grpc.Core;
using GRPCService.ProtoImpl.Util;

namespace GRPCService.ProtoImpl;

public class BookmarkProtoImpl : Bookmark.BookmarkBase
{
    private IBookmarkService _bookmarkService;

    public BookmarkProtoImpl(IBookmarkService _bookmarkService)
    {
        this._bookmarkService = _bookmarkService;
    }

    public override async Task<BookmarkObj> AddBoomark(BookmarkObj request,ServerCallContext context)
    {
        Entities.Models.Bookmark bookmark = ConvertGRPC.ConvertBookmarkObjToBookmark(request);
        var ret = await _bookmarkService.AddBookmark(bookmark);

        return ConvertGRPC.ConvertBookmarkToBookmarkObj(ret);
    }
    
    public override async Task<BookmarkObj> RemoveBookmark(StringAndInteger request,ServerCallContext context)
    {
        string username = request.UserName;
        int postId = request.PostId;
        var ret= await _bookmarkService.RemoveBookmark(postId,username);

        return ConvertGRPC.ConvertBookmarkToBookmarkObj(ret);
    }

}