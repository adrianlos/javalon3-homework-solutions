package pl.sda.marijuana;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
@Setter
@ToString
@Builder
public class PriceSnapshot {
    private String state;
    private BigDecimal highQualityPrice;
    private BigDecimal mediumQualityPrice;
    private BigDecimal lowQualityPrice;
    private Integer month;
    private Integer year;

    public BigDecimal averagePrice() {
        Optional<BigDecimal> optionalSum = Stream.of(
                highQualityPrice,
                mediumQualityPrice,
                lowQualityPrice)
                .filter(Objects::nonNull)
                .reduce(BigDecimal::add);

        return optionalSum
                .map(sum -> sum.divide(new BigDecimal(existingPricesCount())))
                .orElse(BigDecimal.ZERO);


    }

    private long existingPricesCount() {
        return Stream.of(
                highQualityPrice,
                mediumQualityPrice,
                lowQualityPrice)
                .filter(Objects::nonNull)
                .count();
    }
}
