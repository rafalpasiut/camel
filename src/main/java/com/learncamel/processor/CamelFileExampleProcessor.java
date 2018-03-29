package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;

public class CamelFileExampleProcessor implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {
        System.out.println("Exchange in processor is: " + exchange.getIn().getBody());

        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
        if(file!=null){
            FileReader fileReader = new FileReader(file.getFile());
            BufferedReader reader = new BufferedReader(fileReader);
            String changedText = reader.lines()
                    .peek(line -> System.out.println("read line is: " + line))
                    .map(line -> line.replace(",",":"))
                    .collect(Collectors.joining(System.lineSeparator()));
            exchange.getIn().setBody(changedText);
        }
    }
}
