package MUCtivities.model;

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
    
    public static Optional<Boolean> wetterVorhersage() {
        Boolean result;
        try {
            HttpsURLConnection apiConnection = callApi();
            String responsebody = getResponsebody(apiConnection);
            result = isGoodWeather(responsebody);            
        } catch (Exception e) {
            result = null;
        }
        return Optional.ofNullable(result);
    }

    static Boolean isGoodWeather(String responsebody) {
        String weatherIcon = getWeatherIcon(responsebody);
        String FirstTwoCharsOfWeatherIcon = weatherIcon.substring(0, 2);
        int weather = new Integer(FirstTwoCharsOfWeatherIcon);
        return weather < 3;
    }

    static String getWeatherIcon(String responsebody) {
        JSONObject json = new JSONObject(responsebody);
        return json.getJSONArray("weather").getJSONObject(0).getString("icon");
    }

    static String getResponsebody(HttpsURLConnection apiConnection) throws IOException {
        InputStream in = apiConnection.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int byteBlock;
        while ((byteBlock = in.read()) != -1) {
            buffer.write(byteBlock);
        }
        return buffer.toString();
    }

    static HttpsURLConnection callApi() throws MalformedURLException, IOException, ProtocolException {
        URL apiUrl = new URL(api);
        HttpsURLConnection apiConnection = (HttpsURLConnection)apiUrl.openConnection();
        apiConnection.setRequestMethod("GET");
        return apiConnection;
    }
}
