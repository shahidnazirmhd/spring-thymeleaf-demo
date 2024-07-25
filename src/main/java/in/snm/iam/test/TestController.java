package in.snm.iam.test;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "test")
@AllArgsConstructor
public class TestController {

    @GetMapping
    public String testWithGreeting(){
    return "Hello! This is project Iam";
    }
}