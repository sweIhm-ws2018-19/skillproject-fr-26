package main.java.MUCtivities.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class MUCtivitiesIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MUCtivitiesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Hallo Welt";
       return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("HelloWorld", speechText)
                .build();
    }

}
