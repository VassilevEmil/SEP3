package group6.semester.project;

import group6.semester.project.grpcClient.post.PostGRPCClientImpl;
import group6.semester.project.grpcClient.user.GRPCUserClientImpl;
import group6.semester.project.model.Post;
import group6.semester.project.model.User;
import group6.semester.project.services.SericeImpl.UserServiceImpl;
import group6.semester.project.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication

public class Sep3T2Application {

    public static void main(String[] args) {
        testPost();
        SpringApplication.run(Sep3T2Application.class, args);
    }

    private static void testPost() {
        PostGRPCClientImpl postGRPCClient = new PostGRPCClientImpl();
        Post post = new Post();
        post.setTitle("hello");
        post.setPrice(10);
        post.setDescription("Hello again");
        post.setDateCreated(new Date());
        post.setImages(new ArrayList<>());
        post.setAddress("address");
        post.setCondition("bad");
        post.setPhoneNumber("rubbish");
        post.setEmail("sachin@gmail.com");
        post.setComments(new ArrayList<>());
        User user = new User();
        user.setUsername("sachin123");
        user.setPassword("sachin123");
        user.setFirstName("sachin");
        user.setLastName("Hero");
        user.setRole("user");
        post.setWriter(user);
        postGRPCClient.addPost(post,1);


    }

}
