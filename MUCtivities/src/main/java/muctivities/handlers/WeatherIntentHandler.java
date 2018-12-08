package muctivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import muctivities.constants.*;

import muctivities.model.Wetterdienst;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class WeatherIntentHandler implements RequestHandler {

	@Override
	public boolean canHandle(HandlerInput input) {
		return input.matches(intentName("MUCtivitiesIntent"));
	}

	@Override
	public Optional<Response> handle(HandlerInput input) {
		Map<String, Object> sessionAttributes = input.getAttributesManager().getSessionAttributes();
		sessionAttributes.put(Attributes.STATE_KEY, Attributes.LOCATION_STATE);

		Optional<Boolean> aBoolean = Wetterdienst.wetterVorhersage();
		Boolean orElse = aBoolean.orElse(true);
		sessionAttributes.put(Attributes.REPEAT_KEY,
				orElse ? Phrases.WEATHER_SUNNY_REPROMT : Phrases.WEATHER_RAINY_REPROMPT);
		sessionAttributes.put(Attributes.WEATHER_KEY, orElse);
		String speechText = orElse ? Phrases.WEATHER_SUNNY : Phrases.WEATHER_RAINY;

		return input.getResponseBuilder().withSpeech(speechText).withShouldEndSession(false).build();

	}

}
