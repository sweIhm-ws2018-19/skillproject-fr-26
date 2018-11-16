package main.java.MUCtivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import main.java.MUCtivities.attribute.Constants;
import main.java.MUCtivities.eigeneKlassen.Wetterdienst;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class MUCtivitiesIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("MUCtivitiesIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		// String speechText = "Hallo Welt";
		// wetter muss noch angepasst werden.
		String speechText = Wetterdienst.wetterVorhersage() ? Constants.MUCtivitie_SONNIG : Constants.MUCtivitie_REGEN;
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Constants.MUCtivities_Name, speechText)
				.build();
	}

}
