package com.dfpatino.testfeatures.cucumber.stepdefs;

import com.dfpatino.testfeatures.cucumber.CucumberContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.val;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import org.springframework.boot.web.server.LocalServerPort;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS;

public class AbstractSteps {

    @LocalServerPort
    private int port;

    private final Client client;
    private CucumberContext context = CucumberContext.CONTEXT;

    public AbstractSteps() {
        val objectMapper = new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        val jsonProvider = new JacksonJaxbJsonProvider(objectMapper, DEFAULT_ANNOTATIONS);
        client = ClientBuilder.newClient().register(jsonProvider);
    }

    protected CucumberContext cucumberContext() {
        return context;
    }

    protected void doGet(final String path) {
        val response = getInvocationBuilder(path).get();
        context.setResponse(response);
    }

    protected void doPost(final String path, final Object body) {
        val response = getInvocationBuilder(path).post(Entity.entity(body, MediaType.APPLICATION_JSON));
        context.setResponse(response);
    }

    private Invocation.Builder getInvocationBuilder(final String path) {
        WebTarget webTarget = client.target(baseUrl()).path(path);
        return webTarget.request(MediaType.APPLICATION_JSON);
    }

    private String baseUrl() {
        return "http://localhost:".concat(String.valueOf(port));
    }
}
