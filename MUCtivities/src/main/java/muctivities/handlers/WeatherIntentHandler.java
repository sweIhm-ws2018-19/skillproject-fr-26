package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.*;

import muctivities.model.RandomPicker;
import muctivities.model.Wetterdienst;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static com.amazon.ask.request.Predicates.sessionAttribute;

public class WeatherIntentHandler implements RequestHandler {

	@Override
//	public boolean canHandle(HandlerInput input) {
//		return input.matches(intentName("MUCtivitiesIntent"));
//	}
	public boolean canHandle(HandlerInput input) {
		return input.matches(sessionAttribute(Attributes.STATE_KEY, "_START"));
		//sessionAttributes.put(Attributes.STATE_KEY, "_START");
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		sessionAttributes.put(Attributes.STATE_KEY, Attributes.LOCATION_STATE);

//		Optional<Boolean> aBoolean = Wetterdienst.wetterVorhersage();
//		Boolean orElse = aBoolean.orElse(true);
//		sessionAttributes.put(Attributes.REPEAT_KEY,
//				orElse ? Phrases.WEATHER_SUNNY_REPROMT : Phrases.WEATHER_RAINY_REPROMPT);
//		sessionAttributes.put(Attributes.WEATHER_KEY, orElse);
		String speechText = Phrases.WEATHER_RAINY[1];

		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();

	}

}
