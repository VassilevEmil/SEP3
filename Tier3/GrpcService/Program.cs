
using EFC.DAOImpl;
using EFC;
using Entities.Contracts;
using Entities.Models;
using GRPCService.ProtoImpl;


var builder = WebApplication.CreateBuilder(args);

// Additional configuration is required to successfully run gRPC on macOS.
// For instructions on how to configure Kestrel and gRPC clients on macOS, visit https://go.microsoft.com/fwlink/?linkid=2099682

// Add services to the container.
builder.Services.AddGrpc();

//services
//daos
//builder.Services.AddScoped<IMessageDAO, MessageDAOImpl>();
builder.Services.AddScoped<IBookmarkService, BookmarkDAOImpl>();
builder.Services.AddScoped<IUserService, UserDAOImpl>();
builder.Services.AddScoped<IPostService, PostDAOImpl>();
builder.Services.AddScoped<ICommentService, CommentServiceImpl>();
builder.Services.AddScoped<IImageService,ImageDaoImpl>();

builder.Services.AddDbContext<DbAccess>();

var app = builder.Build();

// Configure the HTTP request pipeline.
app.MapGrpcService<BookmarkProtoImpl>();
app.MapGrpcService<UserProtoImpl>();
app.MapGrpcService<PostProtoImpl>();
app.MapGrpcService<CategoryProtoImpl>();
app.MapGrpcService<ImageUploadProtoImpl>();
app.MapGrpcService<CommentProtoImpl>();
app.MapGet("/",
    () =>
        "Communication with gRPC endpoints must be made through a gRPC client. To learn how to create a client, visit: https://go.microsoft.com/fwlink/?linkid=2086909");

app.Run();

