
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

    public override async Task<Message> AddBoomark(BookmarkObj request,ServerCallContext context)
    {
        Entities.Models.Bookmark bookmark = ConvertGRPC.ConvertBookmarkObjToBookmark(request);
        _bookmarkService.AddBookmark(bookmark);

        return new Message();
    }

}