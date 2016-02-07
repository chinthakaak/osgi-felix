package com.examples;

/**
 * Created by ka40215 on 2/7/16.
 */
public class HelloClient {
    static {
        HelloServer helloServer = new HelloServer();
        helloServer.hello();
    }
}
