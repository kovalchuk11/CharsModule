import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

public class RequestCreator {
    public File sendRequest(String json, String fileName) throws IOException {
        String API_URL = "https://quickchart.io/chart";
        StringEntity params = new StringEntity(json, "UTF-8");
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost(API_URL);
        post.setHeader("Content-Type", "application/json;charset=UTF-8");
        post.setEntity(params);

        File file = new File(fileName);

        try (CloseableHttpResponse closeableHttpResponse = (CloseableHttpResponse) httpClient.execute(post)) {
            //Todo handle end do not return file
            if (closeableHttpResponse.getStatusLine().getStatusCode() != 200) {
                System.out.println("Photo didnt create");
            }
            HttpEntity entity = closeableHttpResponse.getEntity();
            if (entity != null) {
                try (FileOutputStream outputStream = new FileOutputStream(file)) {
                    entity.writeTo(outputStream);
                }
            }
        }

        return file;
    }
}