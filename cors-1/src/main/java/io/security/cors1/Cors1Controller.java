package io.security.cors1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Cors1Controller {
    @GetMapping("/")
    public String index(){
        System.out.println("여기 온거 맞지!!!!!!ㅇㅇㅇㅇㅇ?");

        return "/index";
    }
}
