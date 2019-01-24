package com.codeup.myproject.controlers;
import com.codeup.myproject.models.Post;
import com.codeup.myproject.models.Users;
import com.codeup.myproject.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private PostService postService;
    private Users userRepo;
    public PostController(PostService ps , Users userRepo){
        this.postService = ps;
        this.userRepo = userRepo;
    }

    @GetMapping("/posts")
    public String index(Model model) {

        model.addAttribute("posts",postService.all());
        userRepo.count();
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String show(@PathVariable int id, Model model) {
        model.addAttribute("post",postService.findOne(id));
        model.addAttribute("id", id);
        model.addAttribute("user",postService.findOne(id).getUser());
        return "posts/show";

    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post" ,new Post());
        return "posts/create";
    }
    @PostMapping("/posts/create")
    public String saveNewPost(@ModelAttribute Post post) {
        postService.create(post);
        return "redirect:/posts";
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable int id,Model model) {
        model.addAttribute("post",postService.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String showEditForm(@ModelAttribute Post post) {
        postService.edit(post);
        return "redirect:/posts/"+post.getId();
    }


//    @RequestMapping(value="/articles/{articleId}", method=RequestMethod.DELETE)

    @GetMapping("/posts/{id}/delete")
    public String delete(@PathVariable int id) {
        postService.delete(postService.findOne(id));
        return "redirect:/posts";
    }

    @PostMapping("/posts")
    @ResponseBody
    public String save() {
        return "Handle the POST request for saving a new blog post";
    }
}