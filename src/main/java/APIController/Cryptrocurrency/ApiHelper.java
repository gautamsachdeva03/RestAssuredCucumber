package APIController.Cryptrocurrency;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

public class ApiHelper {
    Properties config;

    public ApiHelper(Properties config) {
        this.config = config;
    }

    public Response getCurrencyMap(String symbols) {

        baseURI = config.getProperty("BASE_URI");
        RequestSpecification request = given();
        request.headers("Accept", "application/json");
        request.headers("Accept-Encoding", "gzip, deflate, br");
        request.accept(ContentType.JSON);
        request.contentType(ContentType.JSON);
        request.headers("X-CMC_PRO_API_KEY", config.getProperty("API_KEY"));

        if (!symbols.isEmpty()) {
            request.queryParam("symbol", symbols);
        }

        return request
                .when().get(config.getProperty("GET_CURRENCY_MAP"))
                .then()
                .statusCode(200)
                .extract().response();
    }

    public Response convertCurrency(String symbolId, String conversionCurrency) {

        baseURI = config.getProperty("BASE_URI");
        RequestSpecification request = given();
        request.headers("Accept", "application/json");
        request.headers("Accept-Encoding", "gzip, deflate, br");
        request.accept(ContentType.JSON);
        request.contentType(ContentType.JSON);
        request.headers("X-CMC_PRO_API_KEY", config.getProperty("API_KEY"));
        request.queryParam("amount", 1);
        request.queryParam("id", symbolId);
        request.queryParam("convert", conversionCurrency);

        return request
                .when().get(config.getProperty("GET_PRICE_CONVERSION"))
                .then()
                .statusCode(200)
                .extract().response();
    }

    public Response getTechDocInfoById(String ids) {
        baseURI = config.getProperty("BASE_URI");
        RequestSpecification request = given();
        request.headers("Accept", "application/json");
        request.headers("Accept-Encoding", "gzip, deflate, br");
        request.accept(ContentType.JSON);
        request.contentType(ContentType.JSON);
        request.headers("X-CMC_PRO_API_KEY", config.getProperty("API_KEY"));
        request.queryParam("id", ids);

        return request
                .when().get(config.getProperty("GET_CURRENCY_INFO"))
                .then()
                .statusCode(200)
                .extract().response();
    }

}
