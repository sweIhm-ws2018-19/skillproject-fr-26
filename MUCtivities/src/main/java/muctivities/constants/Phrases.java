package muctivities.constants;

import java.util.ArrayList;
import java.util.List;

public class Phrases {
    private Phrases() {
        throw new IllegalStateException("Utility class");
    }

    public static final String MUCTIVITIES_NAME = "MUCtivities";

    public static final List<String> LAUNCH_REQUEST = new ArrayList<String>() {{
        add("Servus! Ein schöner Tag, um mal wieder etwas zu unternehmen. Sage \"Tipp des Tages\" um einen Vorschlag für eine beliebige Aktivität zu erhalten. Für eine personalisierte Idee, sage \"Was kann ich heute unternehmen?\"");
        add("Servus! Ich bin Peter und du kannst mich nach einem Tipp für Aktivitäten in München oder dem Tipp des Tages fragen.");
        add("Grias di! Frage mich nach einem personalisierten Vorschlag für eine Aktivitäten in München dem Tipp des Tages und ich helfe dir sehr gerne weiter. Wonach suchst du?");
        add("Servus!  Wenn dir langweilig ist, bist du hier genau richtig. Du hast die Wahl: Möchtest du einen personalisierten Vorschlag für eine Aktivität in München erhalten oder den Tipp des Tages hören? ");
        add("Grias di! Du kannst mich nach einem personalisierten Vorschlag für eine Aktivität in München fragen oder den Tipp des Tages anfordern. Was möchtest du gerne?");
    }};

    public static final String HELP_INTENT = "Danke für das öffnen von MUCtivities. Möchtest du die Erfahrung beginnen?";
    public static final String FALLBACK_INTENT = "Tut mir leid, ich verstehe das Wort nicht. Wiederhole es oder sage einfach Hilfe.";

    public static final String WEATHER_SUNNY = "Heute wird ein sonniger Tag. Möchtest du etwas draußen  unternehmen?";
    public static final String WEATHER_RAINY = "Heute ist ein greisliges Wetter draußen, am besten bleibst du heut drin?";
    public static final String WEATHER_SUNNY_REPROMT = "     bitte sage JA, wenn du einen Vorschlag für eine Aktivität im Freien haben möchtest ";
    public static final String WEATHER_RAINY_REPROMPT = "bitte sage JA, wenn du einen Vorschlag für eine Aktivität im Trockenen haben möchtest";

    public static final List<String> DURATION_QUESTION = new ArrayList<String>() {{
        add("Möchtest du nur ein paar Stunden unterwegs sein oder hast du den ganzen Tag Zeit?");
        add("Wie lange möchtest du unterwegs sein? Ein paar Stunden oder den ganzen Tag?");
        add("Wie lang soll die Aktivität dauern? Ein paar Stunden oder den ganzen Tag?");
        add("Wie lang hast du heute Zeit? Ein paar Stunden oder den ganzen Tag? ");
    }};
    public static final String DURATION_REPROMT = "bitte sage „kurz“, wenn du die Aktivität nur ein paar Stunden dauern soll. Sage „lang“ wenn du den ganzen Tag Zeit hast";

    public static final List<String> CATEGORIE_QUESTION = new ArrayList<String>() {{
        add("Alles klar. Ich habe schon viele Ideen für dich. Worauf hast du denn Lust? Du kannst auswählen zwischen. Kultur. Sport. Und Spaß.");
        add("Basst. Um mir eine Aktivität für dich zu überlegen, sage mir worauf du heute Lust hast. Du kannst wählen zwischen: Kultur, Sport oder Spaß. Für welche Kategorie entscheidest du dich?");
        add("Guad! Du kannst die folgenden Kategorien für eine Aktivität auswählen: Kultur, Sport oder Spaß. Worauf hast du Lust?");
        add("Guad! Du kannst die folgenden Kategorien für eine Aktivität auswählen: Kultur, Sport oder Spaß. Welche nimmst du?");
    }};
    public static final String CATEGORIE_REPROMT = "Bitte wähle eine Kategorie aus. Sage „Kultur“, „Sport“ oder „Spaß“ ";

    public static final String INFO_REPROMT = "Wenn dir dieser Vorschlag gefällt, sage „ja“. Wenn du lieber einen neuen Vorschlag möchtest, sage „nein“";

    public static final List<String> MORE_INFORMATION = new ArrayList<String>() {{
        add("Mei des wird a Gaudi. Möchtest du mehr Informationen dazu?");
        add("Mei, des wird gspassig. Soll ich dir die Aktivität näher beschreiben?");
        add("Mei des wird a Gaudi. Hättest du gerne weitere Informationen dazu?");
        add("Mei, des wird gspassig. Würdest du gerne mehr darüber erfahren?");
    }};

    public static final List<String> CANCEL_AND_STOP_INTENT = new ArrayList<String>() {{
        add("Komm morgen wieder, um die Erfahrung wieder zu spielen. Sag einfach \"Alexa, öffne Muctivities\" <break time=\"0.05s\" />, um die Fertigkeit erneut zu öffnen.");
        add("Alles klar. Ich wünsch dir einen schönen Tag und viel Spaß dabei. Bis zum nächsten Mal! Pfiad di Servus!");
        add("Guad, dann wünsch ich dir viel Spaß in München. Bis zum nächsten Mal! Pfiat di, mach’s gut!");
    }};
}
