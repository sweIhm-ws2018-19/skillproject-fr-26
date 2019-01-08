package muctivities.constants;

public class Phrases {
	private Phrases() {
		throw new IllegalStateException("Utility class");
	}

	public static final String[] LAUNCH_REQUEST = new String[] {
			"Servus! Ich bin das Münchner Kindl und du kannst mich nach einem personalisierten Vorschlag für eine Aktivität in München oder nach dem Tipp des Tages fragen. ",
			"Grias di! Ich bin das Münchner Kindl. Frage mich nach einem personalisierten Vorschlag für eine Aktivität in München oder nach dem Tipp des Tages und ich helfe dir sehr gerne weiter. ",
			"Servus!  Ich bin das Münchner Kindl. Wenn dir langweilig ist, bist du hier genau richtig. Möchtest du einen personalisierten Vorschlag für eine Aktivität in München erhalten oder den Tipp des Tages hören? ",
			"Grias di! Ich bin das Münchner Kindl. Du kannst mich nach einem personalisierten Vorschlag für eine Aktivität in München fragen oder den Tipp des Tages anfordern.",
			"Servus! Ich bin das Münchner Kindl. Ein schöner Tag, um mal wieder etwas zu unternehmen. Sage \"Tipp des Tages\" um eine Vorschlag für eine beliebige Aktivität zu erhalten. Für eine personalisierte Idee, sage \"Was kann ich heute unternehmen?\"" };
	public static final String LAUNCH_REQUEST_REPEAT = "Das habe ich leider nicht verstanden. Bitte sage personalisierter Vorschlag oder Tipp des Tages.";
	public static final String HELP_INTENT = "Danke für das öffnen von MUCtivities. Möchtest du die Erfahrung beginnen?";
	public static final String FALLBACK_INTENT = "Tut mir leid, ich verstehe das Wort nicht. Wiederhole es oder sage einfach Hilfe.";

	public static final String[] WEATHER_RAINY = new String[] {
			"Heute ist ein greisliges Wetter draußen. Soll ich lieber eine Aktivität im Trockenen aussuchen?",
			"Heute ist Regen angesagt. Vielleicht sollten wir lieber nach einer Aktivität drinnen suchen. Bist du einverstanden?" };
	public static final String[] WEATHER_SUNNY = new String[] {
			"Für heute ist Sonne angesagt, deshalb empfehle ich eine Aktivität im Freien. Bist du einverstanden damit?",
			"Heute wird das Wetter sehr schön. Das solltest du genießen und nach draußen  gehen. Ist das in Ordnung für dich?" };
	public static final String WEATHER_REPROMPT = "Möchtest du drinnen oder draußen etwas unternehmen?";
	public static final String WEATHER_SUNNY_REPROMT = "bitte sage JA, wenn du einen Vorschlag für eine Aktivität im Freien haben möchtest ";
	public static final String WEATHER_RAINY_REPROMPT = "bitte sage JA, wenn du einen Vorschlag für eine Aktivität im Trockenen haben möchtest";

	public static final String DAILY_TIPP = "Der Tipp des Tages ist %s. Hättest du gerne mehr Informationen dazu?";

	public static final String[] DURATION_QUESTION = new String[] {
			"Wie lange möchtest du unterwegs sein? Ein paar Stunden oder den ganzen Tag?",
			"Wie lang soll die Aktivität dauern? Ein paar Stunden oder den ganzen Tag?",
			"Wie lang hast du heute Zeit? Ein paar Stunden oder den ganzen Tag? ", };
	public static final String DURATION_REPROMT = "bitte sage „kurz“, wenn du die Aktivität nur ein paar Stunden dauern soll. Sage „lang“ wenn du den ganzen Tag Zeit hast";

	public static final String[] CATEGORIE_QUESTION = new String[] {
			"Basst. Um mir eine Aktivität für dich zu überlegen, sage mir worauf du heute Lust hast. Du kannst wählen zwischen: Kultur, Sport oder Spaß. Für welche Kategorie entscheidest du dich?",
			"Guad! Du kannst die folgenden Kategorien für eine Aktivität auswählen: Kultur, Sport oder Spaß. Worauf hast du Lust?",
			"Guad! Du kannst die folgenden Kategorien für eine Aktivität auswählen: Kultur, Sport oder Spaß. Welche nimmst du?", };
	public static final String CATEGORIE_REPROMT = "Bitte wähle eine Kategorie aus. Sage „Kultur“, „Sport“ oder „Spaß“ ";

	public static final String[] NEXT_SUGGESTION = new String[] {
			"Ja mei, dann vielleicht ein anderes Mal. Eine super Aktivität ist auch %s (Gefällt dir die Idee?)",
			"Kein Problem, es gibt noch mehr/andere tolle Aktivitäten. Wie wäre es denn mit %s?",
			"Keine Sorge, München hat noch viel mehr Freizeitaktivitäten zu bieten. Was hältst du von %s?",
			"Alles klar. Wie wäre es dann mit %s?",
			"Okay. Was hältst du stattdessen von %s? Gefällt dir die Idee besser?",
			"Alles klar. Eine andere Idee wäre %s! Gefällt dir die Aktivität besser?" };

	public static final String INFO_REPROMT = "Wenn dir dieser Vorschlag gefällt, sage „ja“. Wenn du lieber einen neuen Vorschlag möchtest, sage „nein“";
	public static final String[] FIRST_SUGGESTION = new String[] {
			"Super Gschicht, da habe ich schon viele Ideen für dich. Wie wäre es denn mit %s?",
			"Sau guad, München hat in dieser Kategorie viel zu bieten! Wie wäre es denn mit %s?",
			"Sau guad, da fällt mir auf Anhieb eine tolle Freizeitaktivität für dich ein. Wie wäre es denn mit %s?"};

	public static final String END_OF_SUGGESTIONS = "Zefix! da war wohl nichts für dich dabei. Möchtest du eine neue Kategorie, dann sage Spaß, Sport, Kultur oder sage beenden?";
	public static final String TIP_OF_DAY_END_QUESTION = "Möchtest du noch einen personalisierten Vorschlag für eine Aktivität haben oder beenden?";
	public static final String[] MORE_INFORMATION = new String[] {
			"Mei des wird a Gaudi. Möchtest du mehr Informationen dazu?",
			"Mei, des wird gspassig. Soll ich dir die Aktivität näher beschreiben?",
			"Mei des wird a Gaudi. Hättest du gerne weitere Informationen dazu?",
			"Mei, des wird gspassig. Würdest du gerne mehr darüber erfahren?", };

	public static final String[] CANCEL_AND_STOP_INTENT = new String[] {
			"Alles klar. Ich wünsch dir einen schönen Tag und viel Spaß dabei. Bis zum nächsten Mal! Pfiad di Servus!",
			"Guad, dann wünsch ich dir viel Spaß in München. Bis zum nächsten Mal! Pfiat di, mach’s gut!", };
	public static final String[] DESCRIPTION_END = new String[] {
			"Viel Spaß und bis zum nächsten Mal! Pfiad di, Servus!",
			"Viel Spaß in München und bis zum nächsten Mal! Pfiat di, mach’s gut!" };

}
