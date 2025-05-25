package Product.Api.product;

public record ProductRequestDTO(String name, String description, double price, String sku,
                                String category, String brand, int stockQuantity,
                                boolean isActive, double weight, String barCode) {
}
