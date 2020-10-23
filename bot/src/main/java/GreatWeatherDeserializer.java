import com.google.gson.*;

import java.lang.reflect.Type;

public class GreatWeatherDeserializer implements JsonDeserializer {
    @Override
    public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        System.out.println("I am deserialize");
        JsonObject jo = jsonElement.getAsJsonObject();
        GreatWeather gw = new GreatWeather();
        JsonObject joTmp = jo.getAsJsonObject("main");
        gw.temp = joTmp.get("temp").toString();
        JsonArray joWeath = jo.getAsJsonArray("weather");
        for (JsonElement weather: joWeath
             ) {
            Weather wTmp = new Weather();
            JsonObject weathJO = (JsonObject) weather;
            wTmp.setMain(weathJO.get("main").toString());
            wTmp.setDescription(weathJO.get("description").toString());
            gw.weather.add(wTmp);

        }


        return gw;
    }
}
