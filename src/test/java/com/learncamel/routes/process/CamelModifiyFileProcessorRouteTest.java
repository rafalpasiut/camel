package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifiyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifiyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        String expectedValue = "123:rafal:jan12" + System.lineSeparator() + "321:fdfd:jun2";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedValue);

        Thread.sleep(5000);

        File file = new File("data/output");

        assertTrue(file.isDirectory());
    }
}