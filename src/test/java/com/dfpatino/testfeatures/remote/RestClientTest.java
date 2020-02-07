package com.dfpatino.testfeatures.remote;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

@Slf4j
@Ignore
public class RestClientTest {

    private final RestClient client = new RestClient();

    @Test
    public void invokeService1() throws InterruptedException, ExecutionException {
        val response1 = client.invokeService1();
        val response2 = client.invokeService2();
        val response3 = client.invokeService3();
        val response4 = client.invokeService4();
        while(!response1.isDone() || !response2.isDone() ||
                !response3.isDone() || !response4.isDone()){
            log.info("waiting...");
            Thread.sleep(200);
        }
        log.info(response1.get().getContentString());
        log.info(response2.get().getContentString());
        log.info(response3.get().getContentString());
        log.info(response4.get().getContentString());
    }
}