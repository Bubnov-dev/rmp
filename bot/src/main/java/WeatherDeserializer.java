import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.List;

public class WeatherDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        System.out.println("hey, i am in deserializer");
        JsonObject jo = jsonElement.getAsJsonObject();
        Weather weather = new Weather();


        JsonObject weath = (JsonObject) jo.get("weather");

        List<JsonObject> jos = (List<JsonObject>) jo.get("weather");
        JsonElement wMain = jos.get(0).get("main");
        String wMainS = wMain.toString();
        weather.setMain(wMainS);
        weather.setDescription(jos.get(0).get("description").toString());

        return weather;
    }
}
