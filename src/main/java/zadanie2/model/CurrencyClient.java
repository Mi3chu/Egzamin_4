package zadanie2.model;

import org.json.JSONObject;
import zadanie2.exceptions.NameNeedToHaveThreeCharLong;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyClient {

    private static final String API_URL = "https://api.apilayer.com/exchangerates_data/";
    private static final String API_URL_SYMBOLS = API_URL + "symbols";
    private static final String API_KEY = "BnW7ENBiBLBknHJSmAIOb4xax9pdohFL";

    public JSONObject getJsonExchange(String currencyFrom, String currencyTo, double amount) throws URISyntaxException, IOException, InterruptedException {
        if (currencyTo.length() != 3 || currencyFrom.length() != 3) {
            throw new NameNeedToHaveThreeCharLong("Name need to have three char long");
        }
        String conURL = API_URL + "convert?to=" + currencyTo + "&from=" + currencyFrom + "&amount=" + amount;

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(API_URL + conURL))
                .header("apiKey", API_KEY)
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        return new JSONObject(postResponse.body());
    }

    public JSONObject getCurrencyNames() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(API_URL_SYMBOLS))
                .header("apikey", API_KEY)
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(postResponse.body());
        return json.getJSONObject("symbols");
    }

}
