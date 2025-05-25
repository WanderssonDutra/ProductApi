package Product.Api.services;

import Product.Api.exceptions.DataConflictException;
import Product.Api.exceptions.DataNotFound;
import Product.Api.product.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
//Service of the Product Controller.
public class ProductService {
    private final ProductRepository repository;
    //This method returns a list of all the data from the database product table.
    public List<ProductResponseDTO> getAll() {
        List<ProductResponseDTO> productResponse = repository.findAll().stream().map(ProductResponseDTO::new).toList();
        return productResponse;
    }
    // This method register some the initial data and do some authentication about duplicated
    // product critical data.
    public void registerProduct(ProductRequestDTO data) {
        if (repository.existsBySku(data.sku()))
            throw new DataConflictException("This sku is already registered.");
        if (repository.existsByBarCode(data.barCode()))
            throw new DataConflictException("The bar code is already registered.");
        Product product = new Product(data);
        repository.save(product);
    }
    // This method update the data by it's's sku data.
    public void updateProduct(ProductUpdateRequestDTO data, String sku) {
        Product product = repository.findBySku(sku).orElseThrow(() -> new DataNotFound
                ("Cannot find the informed product. Please, check if " +
                        "the sku of the product does exist."));
        product.updateProduct(data);
        repository.saveAndFlush(product);
    }
    //this method update the saleprice by it's's sku data.
    public void updateSalePrice(ProductSalePriceDTO data, String sku){
        Product product = repository.findBySku(sku).orElseThrow(()->
                                     new DataNotFound("the product was not found."));
        product.updateSalePrice(data);
        repository.saveAndFlush(product);
    }
}
