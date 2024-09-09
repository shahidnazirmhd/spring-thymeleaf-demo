package in.snm.iam.test;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class TestController {

    @GetMapping("/")
    public String indexPage(){
    return "HIIII";
    }
}