package com.horidream.test.testgraphql.resolver;

import com.horidream.test.testgraphql.domain.bank.UploadFile;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class UploadFileResolver implements GraphQLMutationResolver {
    public UploadFile uploadFile(Part part, DataFetchingEnvironment env){

        try{
            System.out.println("read content: " + IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8));
            part.write("~/downloads/hello.txt");
        }catch (IOException e){

        }
        return UploadFile.builder().fileName("hello").mimeType("text/plain-text").build();
    }
}
