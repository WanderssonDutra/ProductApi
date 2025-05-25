package Product.Api.product;

public record ProductUpdateRequestDTO(String name, String description, double price,
                                      String category, String brand, int stockQuantity,
                                      boolean isActive, double weight) {
}
