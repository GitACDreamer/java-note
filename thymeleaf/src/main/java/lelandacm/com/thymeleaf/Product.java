package lelandacm.com.thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Locale;

@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private Double price;
    private float discountPercent;
    private String type;

    public String formatPrice() {
        return String.format(Locale.CHINA, "%.02f", price*discountPercent);
    }
}
