package Product.Api.product;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponseDTO(UUID id, String name, String description, double price,
                                 String sku, String category, String brand , int stockQuantity,
                                 boolean isActive, LocalDateTime createdAt,
                                 LocalDateTime updatedAt, Number weight,
                                 String barCode, double salePrice,
                                 LocalDateTime saleStartDate, LocalDateTime saleEndDate) {

    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice(),
                product.getSku(), product.getCategory(), product.getBrand(),
                product.getStockQuantity(), product.isActive(), product.getCreatedAt(),
                product.getUpdateAt(), product.getWeight(), product.getBarCode(),
                product.getSalePrice(), product.getSaleStartDate(), product.getSaleEndDate());
    }
}
