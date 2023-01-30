package org.WeeklyTest1;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeeklyTest1 {
    public static void main(String[] args)
    {
        try {
            WeeklyTestAPI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void WeeklyTestAPI() throws URISyntaxException, IOException {
        URIBuilder builder = new URIBuilder("https://www.weatherbit.io/");

        HttpGet getData = new HttpGet(builder.build());

        CloseableHttpClient httpClient = HttpClients.createDefault();

        CloseableHttpResponse response = httpClient.execute(getData);

        //System.out.println(response);

        HttpEntity responseEntity = response.getEntity();
        String result = EntityUtils.toString(responseEntity);
        System.out.println(result);

        httpClient.close();

    }
}