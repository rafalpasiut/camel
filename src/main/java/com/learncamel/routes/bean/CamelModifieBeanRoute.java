package com.learncamel.routes.bean;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifieBeanRoute extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Before bean Changed messages is: ${body}")
                .bean(new CamelBean(),"map")
                .log("After bean Changed messages is: ${body}")
                .to("mock:output");
    }
}
