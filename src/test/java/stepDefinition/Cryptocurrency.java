package stepDefinition;

import APIController.Cryptrocurrency.ApiHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class Cryptocurrency {

    ApiHelper apiHelper = new ApiHelper(Setup.config);
    static HashMap<String, String> coins;
    Response response;
    ResponseBody resBody;

    @When("API: User retrieve the data using cryptocurrency map call")
    public void getDataUsingCryptoCurrencyMap() {
        response = apiHelper.getCurrencyMap("BTC,ETH,USDT");
        coins = new HashMap<>();
        Assert.assertEquals(response.getStatusCode(), 200);
        resBody = response.getBody();
        List<String> resJson = resBody.jsonPath().getList("data");
        for (int i = 0; i < resJson.size(); i++) {
            String json = new Gson().toJson(resJson.get(i));
            JsonPath symbolJson = new JsonPath(json);
            coins.put(symbolJson.get("symbol").toString(), symbolJson.get("id").toString());
        }
        System.out.println(coins);
    }

    @Then("API: User converts the {string} to {string}")
    public void convertCoins(String coinSymbol, String conversionType) {
        for (int i = 0; i < coins.size(); i++) {
            response = apiHelper.convertCurrency(String.valueOf(coins.get(coinSymbol)), conversionType);
            resBody = response.getBody();
            Assert.assertTrue(resBody.jsonPath().get("data.quote").toString().contains(conversionType));
        }
    }

    @When("API: User retrieve the technical documentation for id {string} from info call")
    public void getTechDocInfo(String coinId) {
        response = apiHelper.getTechDocInfoById(coinId);
        resBody = response.getBody();
        HashMap<String, String> mineableCoins = new HashMap<>();

        String[] coinIds = coinId.split(",");
        for (String coin : coinIds) {
            if (coin.equals("1027")) {
                Assert.assertEquals(resBody.jsonPath().get("data." + coin + ".logo").toString(), "https://s2.coinmarketcap.com/static/img/coins/64x64/1027.png");
                Assert.assertEquals(resBody.jsonPath().get("data." + coin + ".urls.technical_doc[0]").toString(), "https://github.com/ethereum/wiki/wiki/White-Paper");
                Assert.assertEquals(resBody.jsonPath().get("data." + coin + ".symbol").toString(), "ETH");
                Assert.assertEquals(resBody.jsonPath().get("data." + coin + ".date_added").toString(), "2015-08-07T00:00:00.000Z");
            }
            if (resBody.jsonPath().get("data." + coin + ".tags").toString().contains("mineable")) {
                mineableCoins.put(resBody.jsonPath().get("data." + coin + ".id").toString(), resBody.jsonPath().get("data." + coin + ".symbol").toString());
            }
        }
        if (!mineableCoins.isEmpty()) {
            System.out.println(mineableCoins);
        }
    }

}
