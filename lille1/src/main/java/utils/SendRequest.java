package utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;





/* ?????????????????????????????????????????????????????????????????
 * ?????????????????????????????????????????????????????????????????
 * http://stackoverflow.com/questions/1322335/what-is-the-best-java-library-to-use-for-http-post-get-etc 
 * 
 * Vous voulez vraiment réécrire un client http ? 
 */
public class SendRequest {
		public static String doRequest(String method, String url, HashMap<String, String>  params, String content) {
			HttpURLConnection con = null;
			URL obj = null;
			try {
				obj = new URL(url);
				con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod(method);
				for (String s : params.values())
					con.setRequestProperty(s, params.get(s));
				con.setDoOutput(true);
				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(content);
				wr.flush();
				wr.close();
				BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				//print result
				return response.toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "";
		}
}
