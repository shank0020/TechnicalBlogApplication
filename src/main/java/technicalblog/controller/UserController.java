package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("users/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration(Model model) {
        User user = new User();
        UserProfile profile = new UserProfile();
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value = "users/registration", method = RequestMethod.POST)
    public String registerUser(User user) {
        //This method will authenticate the user entered data and sent an confirmation email to the user.
        // after authentication user will land into the index page where he/she can login to the site.
        userService.registerUser(user);
        return "users/login";
    }

    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginUser(User user, HttpSession session) {
        //This method will authenticate the user and redirect the user to its posts page.
        User existingUser = userService.login(user);
        if(existingUser != null) {
            session.setAttribute("loggeduser", existingUser);
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }

    @RequestMapping(value = "users/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession session) {
        session.invalidate();
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts", posts);
        return "index";
    }
}
