package com.example.CSV;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AppController{

    public String fileName="ajay/ajendra";

    public List<Emp> lst=new ArrayList<Emp>(Arrays.asList(
            new Emp(1,"java","1000"),new Emp(2,"php","1000"),new Emp(3,"dot","close")
    ));

    @RequestMapping("/csv")
    public ResponseEntity<Object> getCsv() throws IOException {

        StringBuilder sb=new StringBuilder("ID \t NAME \t AGE");
        lst.stream().forEach(e->{
            sb.append("\n").append(e.id).append("\t").append(e.name)
                    .append("\t").append(e.age).append("\n");
        });
        FileWriter fw=new FileWriter(fileName);
        fw.write(sb.toString());
        fw.flush();

        File file=new File(fileName);
        InputStreamResource resource =new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/txt"))
                .body(resource);
    }



}
