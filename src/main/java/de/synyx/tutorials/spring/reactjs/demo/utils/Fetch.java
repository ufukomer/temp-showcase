package de.synyx.tutorials.spring.reactjs.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Fetch {

    public String fetch(String uri) throws IOException {
        URL url = new URL(uri);
        URLConnection uc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));

        String response;
        StringBuffer buffer = new StringBuffer("");
        while ((response = in.readLine()) != null) {
            buffer.append(response + "\n");
        }
        in.close();

        return buffer.toString();
    }
}
