package zadanie2.service;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import zadanie2.exceptions.CurrencyWithThisNameDoNotExist;
import zadanie2.model.CurrencyClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyClient currencyClient;

    public double exchange(String currencyFrom, String currencyTo, double amount) throws URISyntaxException, IOException, InterruptedException {
        checkIfCurrencyExist(currencyFrom,currencyTo);
        JSONObject res = currencyClient.getJsonExchange(currencyFrom,currencyTo,amount);
        return  res.getDouble("result");
    }

    private  List<String> getCurrencyList() throws URISyntaxException, IOException, InterruptedException {
        JSONObject currency = currencyClient.getCurrencyNames();
        return new ArrayList<>(currency.keySet());
    }

    private void checkIfCurrencyExist(String currency1, String currency2) throws URISyntaxException, IOException, InterruptedException {
        List<String> currencyList = getCurrencyList();
        if(!currencyList.contains(currency1) || !currencyList.contains(currency2)) {
            throw new CurrencyWithThisNameDoNotExist("Currency with this name dont exist");
        }
    }
}
