package com.BloggingAssesment;

public class Main {

    public static void main(String[] args) {

        BlogService service = new BlogService();

        User user = service.registerUser(
                "Aryan", "1234", "aryan@mail.com");

        Post post = service.createPost(
                user.getId(),
                "Hibernate Guide",
                "Unidirectional Mapping Example");

        service.addComment(post.getId(), user.getId(),
                "This is my first comment!");

        System.out.println("Blog data inserted successfully.");
    }
}