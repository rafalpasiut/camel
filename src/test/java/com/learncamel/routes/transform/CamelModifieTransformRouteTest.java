package com.learncamel.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CamelModifieTransformRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifieTransformRoute();
    }

    @Test
    public void transformTest(){
        String expected = "123*test*oo";
        String input = "123,test,oo";

        String result = (String)template.requestBody("direct:transformInput", input);
        assertEquals(expected,result);
    }

    @Test
    public void transformUsingMock() throws InterruptedException {
        String expected = "123*test*oo";
        String input = "123,test,oo";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:transformInput",input);

        assertMockEndpointsSatisfied();
    }
}