package Product.Api.product;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public record ProductSalePriceDTO(double salePrice, LocalDateTime saleStartDate,
                                  LocalDateTime saleEndDate, boolean startInCurrentTime,
                                  Boolean saleIsActive) {
}
