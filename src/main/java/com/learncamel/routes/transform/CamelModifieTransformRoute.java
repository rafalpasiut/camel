package com.learncamel.routes.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifieTransformRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:transformInput")
                .transform(body().regexReplaceAll(",","*"))
                .to("mock:output");
    }
}
