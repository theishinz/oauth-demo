package nl.hinz.oauthdemo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpMethod.GET;

@Component
public class OauthDemoResourceService {
    private RestTemplate restOperations;

    public OauthDemoResourceService() {
        restOperations = new RestTemplate();
    }

    public ResponseEntity<String> callService(OAuth2AuthorizedClient authorizedClient) {
        HttpEntity<String> entity = getHttpEntityWithAccessToken(authorizedClient);
        restOperations = new RestTemplate();
        return restOperations.exchange("http://localhost:8081/resource", GET, entity, String.class);
    }

    private HttpEntity<String> getHttpEntityWithAccessToken(final OAuth2AuthorizedClient authorizedClient) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(authorizedClient.getAccessToken().getTokenValue());
        return new HttpEntity<>(headers);
    }

}
