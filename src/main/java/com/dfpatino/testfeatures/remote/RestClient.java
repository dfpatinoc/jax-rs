package com.dfpatino.testfeatures.remote;


import com.twitter.finagle.Http;
import com.twitter.finagle.Service;
import com.twitter.finagle.http.Method;
import com.twitter.finagle.http.Request;
import com.twitter.finagle.http.Response;
import com.twitter.util.Function;
import com.twitter.util.Future;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import scala.runtime.BoxedUnit;

@Slf4j
public class RestClient {

    public java.util.concurrent.Future<? extends Response> invokeService1() {
        val response = invokeService("/api/service-1");
        response.onSuccess(onSuccess("service-1"));
        return response.toJavaFuture();
    }

    public java.util.concurrent.Future<? extends Response> invokeService2() {
        val response = invokeService("/api/service-2");
        response.onSuccess(onSuccess("service-2"));
        return response.toJavaFuture();
    }

    public java.util.concurrent.Future<? extends Response> invokeService3() {
        val response = invokeService("/api/service-3");
        response.onSuccess(onSuccess("service-3"));
        return response.toJavaFuture();
    }

    public java.util.concurrent.Future<? extends Response> invokeService4() {
        val response = invokeService("/api/service-4");
        response.onSuccess(onSuccess("service-4"));
        return response.toJavaFuture();
    }

    private Future<Response> invokeService(final String path) {
        val host = "localhost:9999";
        val client = getStatelessClient(host);
        val request = getRequest(host, path);
        return client.apply(request);
    }

    private Service<Request, Response> getStatelessClient(final String host) {
        return Http.client().newService(host);
    }

    private Request getRequest(final String host, final String path) {
        val request = Request.apply(Method.Get(), path);
        request.headerMap().add("Host", host);
        return request;
    }

    private Function<Response, BoxedUnit> onSuccess(final String serviceName){
        return new Function<Response, BoxedUnit>() {
            @Override
            public BoxedUnit apply(Response v1) {
                log.info("Response service '{}': {}", serviceName, v1);
                return null;
            }
        };
    }

    /*private ServiceFactory<Request, Response> getStatefulClient(final String host) {
        return Http.client().newClient(host);
    }*/
}
