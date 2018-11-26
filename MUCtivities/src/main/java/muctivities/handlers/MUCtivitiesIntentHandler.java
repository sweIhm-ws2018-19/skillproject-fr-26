package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.Phrases;
import muctivities.model.Wetterdienst;

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
		String speechText = Wetterdienst.wetterVorhersage().get() ? Phrases.MUCtivitie_SONNIG : Phrases.MUCtivitie_REGEN;
		return input.getResponseBuilder().withSpeech(speechText).withSimpleCard(Phrases.MUCtivities_Name, speechText)
				.withShouldEndSession(false).build();
//	    return null;

	}

}
