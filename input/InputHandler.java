package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class InputHandler {
	static String sessionCookie;

	static {
		Properties properties = new Properties();
		try
		{
			properties.load(new FileReader("session.properties"));
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
		sessionCookie = "session="+ properties.getProperty("session");
	}


	public static List<String> readFromUrl(String targetUrl) {

		try {
			// Create the URL object
			URL url = new URL(targetUrl);

			// Open a connection to the URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set HTTP method
			connection.setRequestMethod("GET"); // Or POST/PUT as needed

			// Add session cookie to request header
			connection.setRequestProperty("Cookie", sessionCookie);

			// Check response code
			int responseCode = connection.getResponseCode();

			// Read response
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				List<String> response = new ArrayList<>();

				while ((inputLine = in.readLine()) != null) {
					response.add(inputLine);
				}
				in.close();

				// return response
				return response;
			} else {
				System.out.println("Failed to fetch data: " + responseCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}
}
