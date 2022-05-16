package group6.semester.project;

import group6.semester.project.grpcClient.comment.CommentClientImpl;
import group6.semester.project.grpcClient.fileUpload.ImageGrpcImpl;
import group6.semester.project.grpcClient.post.PostGRPCClientImpl;

import group6.semester.project.grpcClient.user.GRPCUserClientImpl;
import group6.semester.project.model.*;

import group6.semester.project.services.UserService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

public class Sep3T2Application {

    public static void main(String[] args)
    {


        SpringApplication.run(Sep3T2Application.class, args);
        //testSearch();

        // testDeleteComment();
     //   testAddComment();
    }

    private static void testAddComment() {
        CommentClientImpl commentClient = new CommentClientImpl();
        Comment comment = new Comment();
        Date date = new Date();
        date.setDay(12);
        date.setMonth(11);
        date.setYear(2022);
        comment.setDateCreated(date);
        comment.setBody("Test from tier 2");
        User user = new User();
        user.setUsername("sachin123");
        user.setFirstName("as");
        user.setLastName("asdf");
        user.setPassword("dsfds");
        user.setRole("sfdf");
        comment.setWriter(user);
      Comment comment1 =  commentClient.addComment(34,comment);
        System.out.println(comment1.getBody());

    }

    private static void testDeleteComment() {
        CommentClientImpl commentClient = new CommentClientImpl();
        Comment comment = commentClient.deleteComment(2);
        System.out.println(comment.getBody());
    }


    private static void testSearch() {
        System.out.println("Search started ::::::::::::::::::::: \n\n\n\n");
        PostGRPCClientImpl postGRPCClient = new PostGRPCClientImpl();
        List<Post> posts = postGRPCClient.getAllPosts(1);
        posts.forEach(System.out::println);
    }



}
