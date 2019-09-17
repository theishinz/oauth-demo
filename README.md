# OAuth2 Demo using Spring Security 5.1

Following project is a demonstration of OAuth2 using Spring Boot 2 & Spring Security 5.1.
As Authorization Server's isn't supported in Spring Security 5.1 is this application, as exception, implemented using Spring Security Oauth.
The demo is setup to use authorization code grant type.

The maven project consist of 3 sub-modules:
1. oauth-demo-client: An OAuth2 Client, default running on port 8080. The client contains a single endpoint that fetches a resource and prints it.
2. auth-demo-resource: A resource application, default  running on port 8081. Contains single resource endpoint that requires the scope: "contratulation".
3. oauth-demo-auth: Authorization server, default running on port 8082. Implemented using Spring Security OAuth. Username and Password is: u/p.
