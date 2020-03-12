package pl.sda.gold;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GoldPriceRetriever {
    private HttpClient httpClient = HttpClient.newHttpClient();

    public BigDecimal fetchGoldPrice() throws IOException, InterruptedException {
        URI uri = URI.create("http://api.nbp.pl/api/cenyzlota/");
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        PriceResponse[] priceResponses = new ObjectMapper().readValue(responseBody, PriceResponse[].class);
        return priceResponses[0].getPrice();
    }

    public GoldPriceRetriever() {
    }

    public GoldPriceRetriever(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class PriceResponse {
        @JsonProperty("cena")
        private BigDecimal price;

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }
    }
}
