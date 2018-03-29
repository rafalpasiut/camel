package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectProcessRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessRoute();
    }

    @Test
    public void processorDirectTest() {
        String expected = "Atest:123:raf3";
        String input = "Atest,123,raf3";

        String output = (String) template.requestBody("direct:processorInput", input);

        assertEquals(expected, output);
    }

    @Test
    public void processorDirectUsingMock() throws InterruptedException {
        String expected = "Atest:123:raf3";
        String input = "Atest,123,raf3";
        MockEndpoint mock = getMockEndpoint("mock:output");

        mock.expectedBodiesReceived(expected);
        template.sendBody("direct:processorInput", input);
        assertMockEndpointsSatisfied();
    }
}