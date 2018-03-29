package com.learncamel.routes.process;

import com.learncamel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Received message before process is ${body} and headers are ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Received message is ${body} and headers are ${headers}")
                //.to("file:data/output?fileName=output.txt");
                .to("mock:output");
    }
}
