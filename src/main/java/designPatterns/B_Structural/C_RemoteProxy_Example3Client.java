package designPatterns.B_Structural;


interface Weather {
    String getWeather();
}


class WeatherService implements Weather {
    @Override
    public String getWeather() {
        System.out.println("Fetching weather from remote server...");
        return "35 degrees Celsius";
    }
}


class WeatherProxy implements Weather {


    private Weather weatherService;

    public WeatherProxy() {
        this.weatherService = new WeatherService();
    }


    @Override
    public String getWeather() {
        authenticate();
        openConnection();
        serializeRequest();
        sendHttpRequest();
        return weatherService.getWeather();
    }

    private void authenticate() {
        // Authentication logic here
        System.out.println("Proxy: Authenticating user...");
    }

    private void openConnection() {
        // Connection logic here
        System.out.println("Proxy: Opening connection...");
    }

    private void serializeRequest() {
        // Serialization logic here
        System.out.println("Proxy: Serializing request...");
    }

    private void sendHttpRequest() {
        // HTTP request logic here
        System.out.println("Proxy: Sending HTTP request...");
    }
}



public class C_RemoteProxy_Example3Client {

    public static void main(String[] args)
    {
        Weather weather = new WeatherProxy();
        String weatherInfo = weather.getWeather();
        System.out.println(weatherInfo);
    }
}
