package fil.tiir.fakedistrib.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import fil.tiir.fakedistrib.entity.Banque;

public class RequestUtil {
	public static String sendRequest(JSONObject toSend, Banque banque, String url) throws IOException {
		return sendRequest(toSend, banque, url, null);
	}

	public static String sendRequest(JSONObject toSend, Banque banque, String url, String token) throws IOException {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost("http://" + banque.getUrl() + "/" + url);
		StringEntity params = new StringEntity(toSend.toString());
		request.addHeader("content-type", "application/json");
		if (token != null)
			request.addHeader("Token", token);
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);
		httpClient.close();
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		return responseString;
	}
}
