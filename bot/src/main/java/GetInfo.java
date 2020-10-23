import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetInfo extends Thread {
    String input;
    Bot bot;
    public GetInfo(String input, Bot bot) {
        this.input = input;
        this.bot = bot;
    }

    @Override
    public void run() {
        aRun();
    }
    public synchronized void aRun(){
        final CloseableHttpClient httpclient = HttpClients.createDefault();
        String city = input;
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=faa0ca0cf9586ea271cb3911327c918f";
        final HttpUriRequest httpGet = new HttpGet(url);
        System.out.println("i am here");
        try
        {
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            final HttpEntity entity1 = response1.getEntity();
            String outJson = EntityUtils.toString(entity1);
            System.out.println(outJson);
            //Weather weather = new Weather();
            GreatWeather gWeather = new GreatWeather();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(GreatWeather.class, new GreatWeatherDeserializer())
                    .create();
            gWeather = gson.fromJson(outJson, GreatWeather.class);
            //System.out.println(gWeather );
            bot.output = gWeather.toString();
            bot.got = true;
            System.out.println("getting info: " + bot.got);
            System.out.println(bot.output);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
