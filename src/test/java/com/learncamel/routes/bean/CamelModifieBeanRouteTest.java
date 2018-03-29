package com.learncamel.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifieBeanRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifieBeanRoute();
    }

    @Test
    public void testBeanModifie() {
        String expected = "123*44*kk";
        String input = "123,44,kk";

        String actual = (String) template.requestBody("direct:beanInput", input);
        assertEquals(expected, actual);
    }
}