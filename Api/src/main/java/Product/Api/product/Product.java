package Product.Api.product;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Product")
@Table
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
//Entity with all the necessary attributes and constructors to register the product data.
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private double price;
    private String sku;
    private String category;
    private String brand;
    private int stockQuantity;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private double weight;
    private String barCode;
    private double salePrice;
    private LocalDateTime saleStartDate;
    private LocalDateTime saleEndDate;
    @Nullable
    private Boolean startInCurrentTime;
    @Nullable
    private Boolean saleIsActive;
// Constructor that register initial data.
    public Product(ProductRequestDTO data){
        this.name = data.name();
        this.description = data.description();
        this.price = data.price();
        this.sku = data.sku();
        this.category = data.category();
        this.brand = data.brand();
        this.stockQuantity = data.stockQuantity();
        this.isActive = data.isActive();
        this.weight = data.weight();
        this.barCode = data.barCode();
        this.createdAt = LocalDateTime.now();
        this.saleIsActive = false;
    }
    //Constructor that update data.
    public void updateProduct(ProductUpdateRequestDTO data){
        if(data.name() != null)
            this.name = data.name();
        if(data.description() != null)
            this.description = data.description();
        if (data.price() != 0)
            this.price = data.price();
        if(data.category() != null)
            this.category = data.category();
        if(data.brand() != null)
            this.brand = data.brand();
        if(data.stockQuantity() != 0)
            this.stockQuantity = data.stockQuantity();
        if(data.isActive() != false)
            this.isActive = data.isActive();
        if(data.weight() != 0)
            this.weight = data.weight();
        this.updateAt = LocalDateTime.now();
    }
    //Constructor that update the sale price data.
    public void updateSalePrice(ProductSalePriceDTO data){
        if(data.saleIsActive() != null)
            this.saleIsActive = data.saleIsActive();
        if(data.saleIsActive() == null && this.saleIsActive == false) {
            this.salePrice = 0;
            this.saleStartDate = null;
            this.saleEndDate = null;
            this.startInCurrentTime = false;
        }else if(data.saleIsActive() == false) {
            this.salePrice = 0;
            this.saleStartDate = null;
            this.saleEndDate = null;
            this.startInCurrentTime = false;
        }
        else {
            if (data.salePrice() != 0)
                this.salePrice = data.salePrice();
            if (data.startInCurrentTime() != true) {
                if (data.saleStartDate() == null) {
                    if (this.saleStartDate == null)
                        this.saleStartDate = LocalDateTime.now();
                } else
                    this.saleStartDate = data.saleStartDate();
            }else
                this.saleStartDate = LocalDateTime.now();
            if (data.saleEndDate() != null)
                this.saleEndDate = data.saleEndDate();
            this.updateAt = LocalDateTime.now();
        }
    }
}
