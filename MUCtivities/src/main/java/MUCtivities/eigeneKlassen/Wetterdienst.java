package main.java.MUCtivities.eigeneKlassen;

import java.util.Random;

public class Wetterdienst {
    
    private static final String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=Munich&APPID=c5a122073fa1a5d290b62089e179531b";
    
    public static Boolean wetterVorhersage() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
