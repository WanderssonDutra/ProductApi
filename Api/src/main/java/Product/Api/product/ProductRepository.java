package Product.Api.product;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    public boolean existsBySkuAndIdNot(String sku, UUID id);

    public boolean existsByBarCodeAndIdNot(String barCode, UUID id);

    public boolean existsBySku(String sku);

    public boolean existsByBarCode(String barCode);

    public Optional<Product> findBySku(String sku);
}
