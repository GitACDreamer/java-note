package lelandacm.com.thymeleaf;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProduceServiceImpl {
    public List<Product> findAll() {
        return Arrays.asList(new Product(1L, "商品A", 20.8, 0.8f, "上衣"),
                new Product(2L, "商品B", 100.0, 0.9f, "裤子"),
                new Product(3L, "商品C", 200.0, 0.5f, "短袖"));
    }
}
