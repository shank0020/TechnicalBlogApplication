package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import technicalblog.service.PostService;
import technicalblog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class HomeController {

    //@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getAllPost(Model model) {
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "index";
    }
}
