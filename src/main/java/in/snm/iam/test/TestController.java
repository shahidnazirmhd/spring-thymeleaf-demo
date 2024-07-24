package in.snm.iam.test;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "test")
@AllArgsConstructor
public class TestController {

    @GetMapping
    public String testWithGreeting(){
    return "Hello! This is project Iam";
    }
}