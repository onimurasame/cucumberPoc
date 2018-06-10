package com.murasame;

import com.murasame.api.SampleRestAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private SampleRestAPI sampleRestAPI;

    @Test
    public void contextLoads() {
        assert sampleRestAPI != null;
    }

}
