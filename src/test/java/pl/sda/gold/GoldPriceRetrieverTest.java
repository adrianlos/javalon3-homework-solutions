package pl.sda.gold;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class GoldPriceRetrieverTest {

    @Test
    void shouldReturnGoldPrice() throws IOException, InterruptedException {
        //given
        HttpResponse<String> response = mock(HttpResponse.class);
        when(response.body()).thenReturn("[{\"cena\": 123.45, \"data\":\"2020-03-03\"}]");

        HttpClient httpClient = mock(HttpClient.class);
        when(httpClient.send(any(), eq(HttpResponse.BodyHandlers.ofString()))).thenReturn(response);

        GoldPriceRetriever goldPriceRetriever = new GoldPriceRetriever(httpClient);
        //when
        BigDecimal goldPrice = goldPriceRetriever.fetchGoldPrice();

        //then
        assertEquals(new BigDecimal("123.45"), goldPrice);
    }

}