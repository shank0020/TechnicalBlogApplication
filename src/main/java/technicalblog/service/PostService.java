package technicalblog.service;

import org.hibernate.query.criteria.internal.expression.SizeOfPluralAttributeExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Service
public class PostService {

    /*String url = "jdbc:postgresql://localhost:5433/technicalblog";
    String username = "postgres";
    String password = "Postgresql@123";*/

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPost() {
        return repository.getAllPosts();
        /*Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from posts");
            while (rs.next()) {
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("body"));
                posts.add(post);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }

    public Post getLatestPost() {
        return repository.getLatestPost();
    }

    public void createPost(Post newPost) {
        newPost.setDate(new Date());
        repository.createPost(newPost);
        System.out.println("New Post:" + newPost);
    }

    public Post getPost(Integer postID) {
        return repository.getPost(postID);
    }

    public void updatePost(Post updatedPost) {
        updatedPost.setDate(new Date());
        repository.updatePost(updatedPost);
    }

    public void deletePost(Integer postID) {
        repository.deletePost(postID);
    }
}
