package in.snm.iam.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    
    @GetMapping("/")
    public String viewIndexPage() {
        return "home";
    }

    @GetMapping("/home")
    public String viewHomePage() {
        return "home";
    }

    @GetMapping("/login")
    public String viewLoginPage() {
        return "login";
    }

    @GetMapping("/hello")
    public String viewGreetPage() {
        return "hello";
    }
    
}
