package com.BloggingAssesment;

import java.util.List;

public class BlogService {

    private UserDao userDAO = new UserDao();
    private PostDAO postDAO = new PostDAO();
    private CommentDAO commentDAO = new CommentDAO();

    public User registerUser(String name, String pass, String email) {
        User u = new User(name, pass, email);
        userDAO.save(u);
        return u;
    }

    public Post createPost(Long userId, String title, String content) {
        User user = userDAO.findById(userId);
        Post post = new Post(title, content, user);
        postDAO.save(post);
        return post;
    }

    public void deletePost(Long postId) {
        Post p = postDAO.findById(postId);
        postDAO.delete(p);
    }

    public void addComment(Long postId, Long userId, String content) {
        Post post = postDAO.findById(postId);
        User user = userDAO.findById(userId);

        Comment c = new Comment(content, post, user);
        commentDAO.save(c);
    }

    public List<Post> getPostsByUser(Long userId) {
        return postDAO.findByUser(userId);
    }

    public List<Comment> getCommentsByPost(Long postId) {
        return commentDAO.findByPost(postId);
    }

    public List<Comment> getCommentsByUser(Long userId) {
        return commentDAO.findByUser(userId);
    }
}