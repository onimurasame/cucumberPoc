package com.murasame;


import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;

@SpringBootTest(
        classes = CucumberPoc.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ContextConfiguration
public abstract class SpringBootStep {

    @Autowired
    protected TestRestTemplate template;

    @Before
    public void before() {
        // demo to show how to add custom header Globally for the http request in spring test template , like  user header
        template.getRestTemplate().setInterceptors(Collections.singletonList((request, body, execution) -> {
            /*request.getHeaders()
                    .add("userHeader", "user");*/
            return execution.execute(request, body);
        }));
    }

}
