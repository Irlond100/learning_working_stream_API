package HTTP_protocol.task1;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	
	public static final String URL = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1" +
		"/cats";
	
	public static ObjectMapper nap = new ObjectMapper();
	
	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create()
			.setDefaultRequestConfig(RequestConfig.custom()
				.setConnectTimeout(7000)    // максимальное время ожидание подключения к серверу
				.setSocketTimeout(30000)    // максимальное время ожидания получения данных
				.setRedirectsEnabled(false) // возможность следовать редиректу в ответе
				.build())
			.build();
		
		HttpGet request = new HttpGet(URL);
		request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());
		
		CloseableHttpResponse response = httpClient.execute(request);
		
		// Arrays.stream(response.getAllHeaders()).forEach(System.out::println);
		
		// String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
		// System.out.println(body);
		
		List<Post> posts = nap.readValue(
			response.getEntity().getContent(),
			new TypeReference<>() {
			}
		);
		
		
		posts.stream()
			.filter(e -> ((e.getUpvotes() != 0)))
			.forEach(System.out::println);
		
		response.close();
		httpClient.close();
	}
	
}
