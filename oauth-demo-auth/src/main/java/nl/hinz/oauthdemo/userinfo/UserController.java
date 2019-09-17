package nl.hinz.oauthdemo.userinfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    @GetMapping("/user/me")
    public UserData user(Principal principal) {
        return new UserData(principal.getName());
    }
}
