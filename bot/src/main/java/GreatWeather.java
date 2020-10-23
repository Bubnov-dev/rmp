import java.util.ArrayList;
import java.util.List;

public class GreatWeather {
   // Coord coord;
    List<Weather> weather = new ArrayList<Weather>();
    String temp;
    //String base;
    //MainJ main;
    //int visibility;
    //Wind wind;
    //Clouds clouds;
    //long dt;
    //Sys sys;
    //int timezone;
    //int id;
    //String name;
    //int cod;

    @Override
    public String toString() {
        String s = weather.toString() + "\n temp: " + (Float.parseFloat(temp)-275.15);
        return s;
    }
}

class Coord{
    float lon;
    float lat;
}

class MainJ{
    float temp;
    float feels_like;
    float temp_Min;
    float temp_Max;
    int pressure;
    int humidity;
}

class Wind{
    float speed;
    int deg;
}

class Clouds{
    int all;
}
class Sys{
    int type;
    int id;
    String country;
    long sunrise;
    long sunset;
}
