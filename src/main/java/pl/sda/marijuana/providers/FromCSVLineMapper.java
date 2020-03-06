package pl.sda.marijuana.providers;

import lombok.RequiredArgsConstructor;
import pl.sda.marijuana.PriceSnapshot;

import java.math.BigDecimal;
import java.time.LocalDate;

@RequiredArgsConstructor
public class FromCSVLineMapper {
    private final String[] csvFields;

    public PriceSnapshot toSnapshot() {
        LocalDate date = LocalDate.parse(csvFields[7]);

        return PriceSnapshot.builder()
                .state(csvFields[0])
                .highQualityPrice(bigDecimalOrNull(csvFields[1]))
                .mediumQualityPrice(bigDecimalOrNull(csvFields[3]))
                .lowQualityPrice(bigDecimalOrNull(csvFields[5]))
                .month(date.getMonth().getValue())
                .year(date.getYear())
                .build();
    }

    private BigDecimal bigDecimalOrNull(String string) {
        try {
            return new BigDecimal(string);
        } catch (NumberFormatException ignore) {
            return null;
        }
    }
}
