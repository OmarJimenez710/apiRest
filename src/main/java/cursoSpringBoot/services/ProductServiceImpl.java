package cursoSpringBoot.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cursoSpringBoot.models.Product;

// notación que indica a Spring que esto es un BEAN
/*
 * lo que hace spring, es almacenarlo en su contenedor para que cuand 
 * yo quiera generar una instancia de clases, es decir una dependencia
 * y luego inyectarla spring sabra automaticamente que tiene que generar 
 * lo que teniamos en la parte del controlador 
 * ProductService productService = new ProductServiceImpl();
 */
@Service
public class ProductServiceImpl implements ProductService {
    // donde debe de estar toda la lógica

    List<Product> productDataBase = new ArrayList<>(Arrays.asList(
            new Product(1, "Laptop", 799.99, 10),
            new Product(2, "Smartphone", 499.99, 25),
            new Product(3, "Tablet", 299.99, 15),
            new Product(4, "Smartwatch", 199.99, 30)));

    @Override
    public List<Product> getProductDataBase() {
        return productDataBase;
    }

}
