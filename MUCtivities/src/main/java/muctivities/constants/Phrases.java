package muctivities.constants;

public class Phrases {
	private Phrases() {
		throw new IllegalStateException("Utility class");
	}

	public static final String MUCTIVITIES_NAME = "MUCtivities";

	public static final String LAUNCH_REQUEST = "Servus! Ein schöner Tag, um mal wieder etwas zu unternehmen. Sage \"Tipp des Tages\" um einen Vorschlag für eine beliebige Aktivität zu erhalten. Für eine personalisierte Idee, sage \"Was kann ich heute unternehmen?\"";

	public static final String CANCEL_AND_STOP_INTENT = "Komm morgen wieder, um die Erfahrung wieder zu spielen. Sag einfach \"Alexa, öffne Muctivities\" <break time=\"0.05s\" />, um die Fertigkeit erneut zu öffnen.";

	public static final String HELP_INTENT = "Danke für das öffnen von MUCtivities. Möchtest du die Erfahrung beginnen?";
	public static final String FALLBACK_INTENT = "Tut mir leid, ich verstehe das Wort nicht. Wiederhole es oder sage einfach Hilfe.";

	public static final String WEATHER_SUNNY = "Heute wird ein sonniger Tag. Möchtest du etwas draußen  unternehmen?";
	public static final String WEATHER_RAINY = "Heute ist ein greisliges Wetter draußen, am besten bleibst du heut drin?";
	public static final String WEATHER_SUNNY_REPROMT = "     bitte sage JA, wenn du einen Vorschlag für eine Aktivität im Freien haben möchtest ";
	public static final String WEATHER_RAINY_REPROMPT = "bitte sage JA, wenn du einen Vorschlag für eine Aktivität im Trockenen haben möchtest";

	public static final String DURATION_QUESTION = "Möchtest du nur ein paar Stunden unterwegs sein oder hast du den ganzen Tag Zeit?";
	public static final String DURATION_REPROMT = "bitte sage „kurz“, wenn du die Aktivität nur ein paar Stunden dauern soll. Sage „lang“ wenn du den ganzen Tag Zeit hast";

	public static final String CATEGORIE_FRAGE = "Alles klar. Ich habe schon viele Ideen für dich. Worauf hast du denn Lust? Du kannst auswählen zwischen. Kultur. Sport. Und Spaß.";
	public static final String CATEGORIE_REPROMT = "Bitte wähle eine Kategorie aus. Sage „Kultur“, „Sport“ oder „Spaß“ ";

	public static final String INFO_REPROMT = "Wenn dir dieser Vorschlag gefällt, sage „ja“. Wenn du lieber einen neuen Vorschlag möchtest, sage „nein“";
}
