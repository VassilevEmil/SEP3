using Entities.Models;
using Google.Protobuf.Collections;
using Grpc.Core;

namespace GRPCService.ProtoImpl.Util;

public class ConvertGRPC {
    public static Entities.Models.User GetUserFromUserObj(UserObj userObj) {
        Entities.Models.User user = new Entities.Models.User() {
            Username = userObj.Username,
            Password = userObj.Password,
            Role = userObj.Role,
            FirstName = userObj.FirstName,
            LastName = userObj.LastName
        };
        return user;
    }

    public static UserObj GetUserObjFromUser(Entities.Models.User request) {
        UserObj userObj = new UserObj() {
            Username = request.Username,
            Password = request.Password,
            Role = request.Role,
            FirstName = request.FirstName,
            LastName = request.LastName
        };
        return userObj;
    }


    public static Entities.Models.Post ConvertPostObjToPost(PostObj request) {
        Entities.Models.Post post = new Entities.Models.Post() {
            Id = request.Id,
            Description = request.Description,
            Address = request.Address,
            Email = request.Email,
            Condition = request.Condition,
            Images = GetImagesFromRepetionion(request.Images),
            Price = request.Price,
            Title = request.Title,
            Writer = GetUserFromUserObj(request.Writer),
            DateCreated = new DateOnly(request.DateCreated.Year, request.DateCreated.Month, request.DateCreated.Day),
            PhoneNumber = request.PhoneNumber
        };
        return post;
    }

    public static Entities.Models.Bookmark ConvertBookmarkObjToBookmark(BookmarkObj request)
    {
        Entities.Models.Bookmark bookmark = new Entities.Models.Bookmark()
        {
            User = GetUserFromUserObj(request.User),
            Post = ConvertPostObjToPost(request.Post)
        };
        return bookmark;
    }
    
    public static ListOfPostObj ConvertListPostToObj(List<Entities.Models.Post> request) {
        ListOfPostObj postObj = new ListOfPostObj();
        foreach (var item in request) {
            postObj.List.Add(ConvertPostToPostObj(item));
        }

        return postObj;
    }
    
    public static ListOfPostsForBooking ConvertListPostToObjBooking(List<Entities.Models.Post> request) {
        ListOfPostsForBooking postObj = new ListOfPostsForBooking();
        foreach (var item in request) {
            PostObj postObj2 = new PostObj() {
                Id = item.Id,
                Description = item.Description,
                Address = item.Address,
                Email = item.Email,
                Condition = item.Condition,
                Images = {new ImageObj()},
                Price = item.Price,
                Title = item.Title,
                Writer = new UserObj(),
                DateCreated = new DateCreated() {
                    Day = item.DateCreated.Day,
                    Month = item.DateCreated.Month,
                    Year = item.DateCreated.Year
                },
                PhoneNumber = item.PhoneNumber,
            };
            postObj.Post.Add(postObj2);
        }

        return postObj;
    }

    public static BookmarkObj ConvertBookmarkToBookmarkObj(Entities.Models.Bookmark reqest)
    {
        BookmarkObj bookmarkObj = new BookmarkObj()
        {
            Post = ConvertPostToPostObj(reqest.Post),
            User = ConvertUserToUserObj(reqest.User)
        };
        return bookmarkObj;
    }

    public static UserObj ConvertUserToUserObj(Entities.Models.User reqest)
    {
        UserObj userObj = new UserObj()
        {
            Username = reqest.Username,
            Password = reqest.Password,
            FirstName = reqest.FirstName,
            LastName = reqest.LastName,
            Role = reqest.Role
        };
        return userObj;
    }
    
    public static PostObj ConvertPostToPostObj(Entities.Models.Post request) {
        return new PostObj() {
            Id = request.Id,
            Description = request.Description,
            Address = request.Address,
            Email = request.Email,
            Condition = request.Condition,
            Images = {GetRepeatedImageObjFromImage(request.Images)},
            Price = request.Price,
            Title = request.Title,
            Writer = GetUserObjFromUser(request.Writer),
            DateCreated = new DateCreated() {
                Day = request.DateCreated.Day,
                Month = request.DateCreated.Month,
                Year = request.DateCreated.Year
            },
            PhoneNumber = request.PhoneNumber,
        };
    }


    public static RepeatedField<PostObj>
        GetRepeatedFieldOfPostFromListOfPosts(List<Entities.Models.Post> posts) {
        RepeatedField<PostObj> repeatedField = new RepeatedField<PostObj>();
        foreach (Entities.Models.Post post in posts) {
            repeatedField.Add(ConvertPostToPostObj(post));
        }

        return repeatedField;
    }

    public static List<Image> GetImagesFromRepetionion(RepeatedField<ImageObj> imageObjs) {
        List<Image> images = new List<Image>();

        foreach (ImageObj imageObj in imageObjs) {
            images.Add(new Image() {
                Id = imageObj.Id,
                Href = imageObj.Href
            });
        }

        return images;
    }

    public static RepeatedField<ImageObj> GetRepeatedImageObjFromImage(
        ICollection<Entities.Models.Image> images) {
        RepeatedField<ImageObj> imageObjs = new RepeatedField<ImageObj>();
        foreach (Image variableImage in images) {
            imageObjs.Add(new ImageObj() {
                Id = variableImage.Id,
                Href = variableImage.Href
            });
        }

        return imageObjs;
    }

    public static CategoryObj GetGRPCCategoryFromCategory(Entities.Models.Category category) {
        CategoryObj categoryObj = new CategoryObj() {
            Id = category.Id,
            Name = category.Name,
            SubCategories = {GetRepeatedSubCategoryFromListOfSubCategories(category.Subcategories)}
        };
        return categoryObj;
    }


    public static RepeatedField<CategoryObj> GetRepeatedFieldOfCategoryObjFromListOfCategory(
        List<Entities.Models.Category> categories) {
        RepeatedField<CategoryObj> categoryObjs = new RepeatedField<CategoryObj>();

        foreach (Entities.Models.Category category in categories) {
            categoryObjs.Add(GetGRPCCategoryFromCategory(category));
        }

        return categoryObjs;
    }


    public static SubcategoryObj GetSubcategoryObjFromSubCategory(Entities.Models.Subcategory subcategory) {
        SubcategoryObj subcategoryObj = new SubcategoryObj() {
            Id = subcategory.Id,
            Name = subcategory.Name,
        };
        return subcategoryObj;
    }


    private static RepeatedField<SubcategoryObj> GetRepeatedSubCategoryFromListOfSubCategories(
        ICollection<Subcategory> categorySubcategories) {
        RepeatedField<SubcategoryObj> subcategories = new RepeatedField<SubcategoryObj>();

        foreach (var subcategory in categorySubcategories) {
            subcategories.Add(GetSubcategoryObjFromSubCategory(subcategory));
        }

        return subcategories;
    }

    public static CommentObj GetCommentObjFromComment(Comment comment) {
        return new CommentObj() {
            Body = comment.Body,
            Id = comment.Id,
            Writer = GetUserObjFromUser(comment.Writer),
            DateCreated = new DateCreatedForComment() {
                Day = comment.DateCreated.Day,
                Month = comment.DateCreated.Month,
                Year = comment.DateCreated.Year
            }
        };
    }

    public static Comment GetCommentFromCommentObj(CommentObj commentObj) {
        return new Comment() {
            Body = commentObj.Body,
            Id = commentObj.Id,
            Writer = GetUserFromUserObj(commentObj.Writer),
            DateCreated = new DateOnly(commentObj.DateCreated.Year, commentObj.DateCreated.Month,
                commentObj.DateCreated.Day)
        };
    }

    public static RepeatedField<CommentObj> GetRepeatedFieldsOfCommentObjsFromListOfComments(
        ICollection<Entities.Models.Comment> comments) {
        RepeatedField<CommentObj> commentObjs = new RepeatedField<CommentObj>();

        foreach (Comment comment in comments) {
            commentObjs.Add(GetCommentObjFromComment(comment));
        }

        return commentObjs;
    }

    public static PostObj ConvertPostToPostObjWithComments(Entities.Models.Post request) {
        return new PostObj() {
            Id = request.Id,
            Description = request.Description,
            Address = request.Address,
            Email = request.Email,
            Condition = request.Condition,
            Images = {GetRepeatedImageObjFromImage(request.Images!)},
            Price = request.Price,
            Title = request.Title,
            Writer = GetUserObjFromUser(request.Writer!),
            DateCreated = new DateCreated() {
                Day = request.DateCreated.Day,
                Month = request.DateCreated.Month,
                Year = request.DateCreated.Year
            },
            PhoneNumber = request.PhoneNumber,
            Comments = { GetRepeatedFieldsOfCommentObjsFromListOfComments(request.Comments!) }
        }; 
    }
}