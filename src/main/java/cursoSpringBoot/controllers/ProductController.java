package cursoSpringBoot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cursoSpringBoot.services.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductServiceImpl productService = new ProductServiceImpl();

    @GetMapping
    public ResponseEntity<?> getProductList() {
        return ResponseEntity.ok(productService.getProductDataBase());
    }

}
