using Entities.Models;
using Google.Protobuf.Collections;

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

    public static PostObj ConvertPostToPostObj(Entities.Models.Post request) {
        PostObj postObj = new PostObj() {
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
            PhoneNumber = request.PhoneNumber
        };
        return postObj;
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

    public static RepeatedField<ImageObj> GetRepeatedImageObjFromImage(ICollection<Entities.Models.Image> images) {
        RepeatedField<ImageObj> imageObjs = new RepeatedField<ImageObj>();
        foreach (Image variableImage in images) {
            imageObjs.Add(new ImageObj() {
                Id = variableImage.Id,
                Href = variableImage.Href
            });
        }

        return imageObjs;
    }
}