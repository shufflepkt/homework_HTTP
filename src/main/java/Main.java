import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String LINK = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(LINK);
        CloseableHttpResponse response = httpClient.execute(request);

        List<CatFacts> catFactsList = mapper.readValue(
                response.getEntity().getContent(),
                new TypeReference<>() {
                }
        );

        System.out.println("Факты о кошках, за которые проголосовали:");

        catFactsList.stream()
                .filter(x -> x.getUpvotes() != null && x.getUpvotes() > 0)
//                .forEach(System.out::println);
                .forEach(x -> System.out.println(x.getText()));

        response.close();
        httpClient.close();
    }
}