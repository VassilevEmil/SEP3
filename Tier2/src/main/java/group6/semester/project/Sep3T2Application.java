package group6.semester.project;

import group6.semester.project.grpcClient.post.PostGRPCClientImpl;

import group6.semester.project.grpcClient.user.GRPCUserClientImpl;
import group6.semester.project.model.Category;
import group6.semester.project.model.Post;
import group6.semester.project.model.Subcategory;
import group6.semester.project.model.User;

import group6.semester.project.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication

public class Sep3T2Application {

    public static void main(String[] args) {


        SpringApplication.run(Sep3T2Application.class, args);
        testSearch();
    }

    private static void testSearch() {
        PostGRPCClientImpl postGRPCClient = new PostGRPCClientImpl();
        List<Post> posts = postGRPCClient.searchPosts("test");
        posts.forEach(System.out::println);
    }



}
