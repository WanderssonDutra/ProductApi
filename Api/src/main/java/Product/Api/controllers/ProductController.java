package Product.Api.controllers;


import Product.Api.product.ProductRequestDTO;
import Product.Api.product.ProductSalePriceDTO;
import Product.Api.product.ProductUpdateRequestDTO;
import Product.Api.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "product")
@RequiredArgsConstructor
public class ProductController {

    // Service of this Controller that will be used in the endpoints to put in practice
    // the business rules.
    private final ProductService service;

    // Endpoint that will request the entire product list.
    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping
    public ResponseEntity registerProduct(@RequestBody ProductRequestDTO data){
        service.registerProduct(data);
        return ResponseEntity.ok("product successfully registered.");
    }
    // Endpoint that will request the product sku attribute registered in the database.
    // to update the product data.
    @PutMapping("/{sku}")
    public ResponseEntity updateProduct(@RequestBody ProductUpdateRequestDTO data,
                                        @PathVariable String sku ){
        service.updateProduct(data, sku);
        return ResponseEntity.ok("the product was successfully updated.");
    }
    // Endpoint that will request the product sku attribute registered in the database
    // to update the saleprice data.
    @PutMapping("/saleprice/{sku}")
    public ResponseEntity updateSalePrice(@RequestBody ProductSalePriceDTO data,
                                          @PathVariable String sku){
        service.updateSalePrice(data, sku);
        return ResponseEntity.ok("SalePrice successfully updated.");
    }
}
