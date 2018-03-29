package com.learncamel.processor;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class CustomProcessorXstream implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String newBocy = exchange.getIn().getBody(String.class);
        StringTokenizer stringTokenizer = new StringTokenizer(newBocy, ",");

        Employee employee = new Employee();
        while (stringTokenizer.hasMoreElements()) {
            employee.setId(Long.parseLong((String) stringTokenizer.nextElement()));
            employee.setName((String)stringTokenizer.nextElement());
            employee.setJoinDate((String)stringTokenizer.nextElement());
        }

        exchange.getIn().setBody(employee);
    }
}
