package com.revature.location.find.router;

import com.revature.location.find.handler.CustomerHandler;
import com.revature.location.find.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler handler;

    @Autowired
    private CustomerStreamHandler  streamHandler;

    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/customer",handler::loadCustomers)
                .GET("/router/customer/stream",streamHandler::getCustomers)
                .GET("/router/customer/{input}", handler::findCustomer)
                .POST("/router/customer/save",handler::saveCustomer)
                .build();
    }
}
