using Entities.Contracts;
using Grpc.Core;
using GRPCService.ProtoImpl.Util;

namespace GRPCService.ProtoImpl; 

public class CategoryProtoImpl : Category.CategoryBase {

    private IPostService _postService;

    public CategoryProtoImpl(IPostService postService) {
        _postService = postService;
    }

    public async override Task<ListOfCategoryObj> GetAllCategories(Empty request, ServerCallContext context) {

        List<Entities.Models.Category> categories = await _postService.GetAllCategories();
        ListOfCategoryObj listOfCategoryObj = new ListOfCategoryObj() {
            AllCategories = {ConvertGRPC.GetRepeatedFieldOfCategoryObjFromListOfCategory(categories)}
        };
        return listOfCategoryObj;
    }
}