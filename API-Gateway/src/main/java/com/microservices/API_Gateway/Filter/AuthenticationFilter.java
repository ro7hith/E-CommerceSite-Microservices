package com.microservices.API_Gateway.Filter;
import org.springframework.http.HttpHeaders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>
{
	@Autowired
    private RoutingValidator validator;

   @Autowired
   RestTemplate template;
    @Autowired
    private JwtUtils jwtUtil;

	public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
        	System.out.print(exchange.getRequest()+ " Exchange");
            if (validator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("missing authorization header");
                }

                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                System.out.println(authHeader + " Header  ");
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
//                //REST call to AUTH service
                // template.getForObject("http://AUTH-SERVICE//validate?token" + authHeader, String.class);
                    jwtUtil.validatetoken(authHeader);

                } catch (Exception e) {
                    System.out.println("invalid access...!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }


	
	public static class Config{}

}
