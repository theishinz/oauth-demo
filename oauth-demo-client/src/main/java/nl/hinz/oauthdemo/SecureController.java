package nl.hinz.oauthdemo;

import nl.hinz.oauthdemo.service.OauthDemoResourceService;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class SecureController {

    private OauthDemoResourceService oauthDemoResourceService;

    public SecureController(final OauthDemoResourceService oauthDemoResourceService) {
        this.oauthDemoResourceService = oauthDemoResourceService;
    }

    @RequestMapping("/")
    public String user(final @RegisteredOAuth2AuthorizedClient("oauth-demo-auth") OAuth2AuthorizedClient authorizedClient,
           final Principal principal){
        ResponseEntity<String> resource = oauthDemoResourceService.callService(authorizedClient);

        if (resource.getStatusCode().equals(OK) ) {
            return "User: " + principal.getName() + ", SecureResourceResponse: " + resource.getBody();
        } else {
            return "Failed with status: " + resource.getStatusCode();
        }
    }


}
