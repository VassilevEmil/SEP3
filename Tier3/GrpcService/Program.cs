using Application.DAOInterfaces;
using Application.ServiceImpl;
using EFC.DAOImpl;
using EFC;
using Entities.Contracts;
using GRPCService.ProtoImpl;
using Microsoft.AspNetCore.Builder;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

var builder = WebApplication.CreateBuilder(args);

// Additional configuration is required to successfully run gRPC on macOS.
// For instructions on how to configure Kestrel and gRPC clients on macOS, visit https://go.microsoft.com/fwlink/?linkid=2099682

// Add services to the container.
builder.Services.AddGrpc();

//services
builder.Services.AddScoped<IUserService,UserServiceImpl>();
//daos
//builder.Services.AddScoped<IMessageDAO, MessageDAOImpl>();
builder.Services.AddScoped<IUserDAO, UserDAOImpl>();
builder.Services.AddDbContext<DbAccess>();

var app = builder.Build();

// Configure the HTTP request pipeline.
app.MapGrpcService<UserProtoImpl>();
app.MapGet("/",
    () =>
        "Communication with gRPC endpoints must be made through a gRPC client. To learn how to create a client, visit: https://go.microsoft.com/fwlink/?linkid=2086909");

app.Run();

