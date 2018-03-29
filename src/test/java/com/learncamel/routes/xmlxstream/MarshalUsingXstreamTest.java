package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public void testMarshalUsingXStream() throws InterruptedException {
        String input = "123,rafal,test";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><Employee><id>123</id><joinDate>test</joinDate><name>rafal</name></Employee>";
        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);
        template.sendBody("direct:csvinput", input);
        assertMockEndpointsSatisfied();

    }
}