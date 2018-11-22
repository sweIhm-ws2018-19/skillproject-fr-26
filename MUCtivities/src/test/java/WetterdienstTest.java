package test.java;

import org.junit.Assert;

import java.util.Optional;

import org.junit.Test;

import main.java.MUCtivities.eigeneKlassen.Wetterdienst;

public class WetterdienstTest {

    String responseExampleBadWeather = "{\"coord\":{\"lon\":11.58,\"lat\":48.14},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"50n\"},{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"},{\"id\":741,\"main\":\"Fog\",\"description\":\"fog\",\"icon\":\"50n\"}],\"base\":\"stations\",\"main\":{\"temp\":273.29,\"pressure\":1016,\"humidity\":100,\"temp_min\":271.15,\"temp_max\":275.15},\"visibility\":3500,\"wind\":{\"speed\":2.1,\"deg\":120},\"clouds\":{\"all\":90},\"dt\":1542822600,\"sys\":{\"type\":1,\"id\":4914,\"message\":0.0271,\"country\":\"DE\",\"sunrise\":1542781808,\"sunset\":1542814129},\"id\":2867714,\"name\":\"Munich\",\"cod\":200}";
    String responseExampleGoodWeather = "{\"coord\":{\"lon\":11.58,\"lat\":48.14},\"weather\":[{\"id\":701,\"main\":\"Mist\",\"description\":\"mist\",\"icon\":\"01n\"},{\"id\":300,\"main\":\"Drizzle\",\"description\":\"light intensity drizzle\",\"icon\":\"09n\"},{\"id\":741,\"main\":\"Fog\",\"description\":\"fog\",\"icon\":\"50n\"}],\"base\":\"stations\",\"main\":{\"temp\":273.29,\"pressure\":1016,\"humidity\":100,\"temp_min\":271.15,\"temp_max\":275.15},\"visibility\":3500,\"wind\":{\"speed\":2.1,\"deg\":120},\"clouds\":{\"all\":90},\"dt\":1542822600,\"sys\":{\"type\":1,\"id\":4914,\"message\":0.0271,\"country\":\"DE\",\"sunrise\":1542781808,\"sunset\":1542814129},\"id\":2867714,\"name\":\"Munich\",\"cod\":200}";

    @Test
    public void testMain() {
        Optional<Boolean> isGoodWeather = Wetterdienst.wetterVorhersage();
        Assert.assertTrue(isGoodWeather.isPresent());
    }
    
    @Test
    public void testGetWeatherIcon() {
        String weatherIcon = Wetterdienst.getWeatherIcon(responseExampleGoodWeather);
        Assert.assertEquals(3, weatherIcon.length());
    }

    @Test
    public void testIsGoodWeather() {
        Assert.assertEquals(false, Wetterdienst.isGoodWeather(responseExampleBadWeather));
        Assert.assertEquals(true, Wetterdienst.isGoodWeather(responseExampleGoodWeather));
    }

}
