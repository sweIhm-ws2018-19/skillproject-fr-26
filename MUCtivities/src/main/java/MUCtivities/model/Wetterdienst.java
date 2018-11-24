package muctivities.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Optional;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;



public class Wetterdienst {
    
    private static final String api = "https://api.openweathermap.org/data/2.5/weather?q=Munich&APPID=c5a122073fa1a5d290b62089e179531b";
    private static final int KELVIN_CELSIUS_DIFFERENCE = 273;
    
    public static Optional<Boolean> wetterVorhersage() {
        Boolean result;
        try {
            HttpsURLConnection apiConnection = callApi();
            JSONObject responsebody = getResponsebody(apiConnection);
            result = isGoodWeather(responsebody);            
        } catch (Exception e) {
            result = null;
        }
        return Optional.ofNullable(result);
    }

    static Boolean isGoodWeather(JSONObject responseBody) {
    	int weatherIcon = getWeatherIcon(responseBody);
    	int temperature = getTemperature(responseBody);
        return weatherIcon < 3 && temperature >= 15;
    }

    /**
     * Reads the Kelvin temperature and converts in to Celsius.
     * @param responseBody
     * @return Temperature in Celsius
     */
	static int getTemperature(JSONObject responseBody) {
		int kelvinTemp = responseBody.getJSONObject("main").getInt("temp");
		return kelvinTemp - KELVIN_CELSIUS_DIFFERENCE;
	}

	/**
     * First two chars of weather icon
     * Weather Icon format in responseBody is: ddx
     * "d" represents a decimal and "x" is either character 'd' (day) or 'n' (night)
     * @param responseBody Response as json
     * @return Returns weather icon as decimal consisting of the first two characters
     */
    static Integer getWeatherIcon(JSONObject responseBody) {
        String weatherIcon = responseBody.getJSONArray("weather").getJSONObject(0).getString("icon");
        String FirstTwoCharsOfWeatherIcon = weatherIcon.substring(0, 2);
    	return new Integer(FirstTwoCharsOfWeatherIcon);
    }

    static JSONObject getResponsebody(HttpsURLConnection apiConnection) throws IOException {
        InputStream in = apiConnection.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int byteBlock;
        while ((byteBlock = in.read()) != -1) {
            buffer.write(byteBlock);
        }
        String responseBody = buffer.toString();
        return new JSONObject(responseBody);
    }

    static HttpsURLConnection callApi() throws MalformedURLException, IOException, ProtocolException {
        URL apiUrl = new URL(api);
        HttpsURLConnection apiConnection = (HttpsURLConnection)apiUrl.openConnection();
        apiConnection.setRequestMethod("GET");
        return apiConnection;
    }
}
