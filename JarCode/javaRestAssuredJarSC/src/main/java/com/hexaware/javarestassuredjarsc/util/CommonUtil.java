package com.hexaware.javarestassuredjarsc.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
public class CommonUtil {
    public static final String host;
    public static final String port;
    //public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
		port = System.getProperty("service.port", "80");
        //port = System.getProperty("service.port", "9090");
        uri_prefix = "http://" + host + ":" + port + "/crmstest/api/" + "";

    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}
