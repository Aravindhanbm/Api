package step.difinition;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class RequestSpecfication {
    RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {
        PrintStream logPrintStream = new PrintStream(Files.newOutputStream(Paths.get("logging.txt")));
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream(".\\File.property");
        property.load(fileInputStream);
        String property2 = property.getProperty("URL");
        RestAssured.baseURI = property2;
        req = new RequestSpecBuilder().setBaseUri(property2).setContentType(ContentType.JSON)
                .addFilter(ResponseLoggingFilter.logResponseTo(logPrintStream)).addFilter(RequestLoggingFilter.logRequestTo(logPrintStream)).build();
        return req;
    }
}
