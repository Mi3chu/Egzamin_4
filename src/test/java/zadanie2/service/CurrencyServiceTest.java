package zadanie2.service;

import org.json.JSONObject;
import org.junit.Test;
import zadanie2.exceptions.CurrencyWithThisNameDoNotExist;
import zadanie2.model.CurrencyClient;


import java.io.IOException;
import java.net.URISyntaxException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CurrencyServiceTest {
    private final CurrencyClient currencyClient = mock(CurrencyClient.class);
    private final CurrencyService currencyService = new CurrencyService(currencyClient);

    @Test
    public void shouldReturn406WhenExchanging100FromUSDToPLN() throws URISyntaxException, IOException, InterruptedException{
        String usd = "USD";
        String pln = "PLN";
        double amountUSD = 100.0;
        double expectedPLN = 409.841;

        when(currencyClient.getCurrencyNames()).thenReturn(expecetedCurrencyNames());
        when(currencyClient.getJsonExchange(usd,pln,amountUSD)).thenReturn(expectedJSONString());

        double result = currencyService.exchange(usd, pln, amountUSD);
        assertEquals(expectedPLN, result, 0.1);
    }

    @Test (expected = CurrencyWithThisNameDoNotExist.class)
    public void shouldThrowExceptionIfCurrencyNotExist() throws URISyntaxException, IOException, InterruptedException, CurrencyWithThisNameDoNotExist {
        when(currencyClient.getCurrencyNames()).thenReturn(expecetedCurrencyNames());
        currencyService.exchange("AAA","PLN",10);
    }

    private JSONObject expecetedCurrencyNames() {
        String jsonString = "{\"USD\":\"United States Dollar\",\"PLN\":\"Polish Zloty\"}";
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }
    private JSONObject expectedJSONString() {
        String jsonString = "{\"date\":\"2023-08-17\",\"result\":409.841,\"success\":true,\"query\":{\"amount\":100," +
                "\"from\":\"USD\",\"to\":\"PLN\"},\"info\":{\"rate\":4.09841,\"timestamp\":1692278584}}";
        JSONObject jsonObject = new JSONObject(jsonString);
        return jsonObject;
    }

}
