package nl.hinz.oauthdemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecureController {

    @RequestMapping("/resource")
    @PreAuthorize("hasAuthority('SCOPE_congratulation')")
    public String user(){
        return "Congratulation";
    }
    
}
