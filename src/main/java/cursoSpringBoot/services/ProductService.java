package cursoSpringBoot.services;

import java.util.List;

import cursoSpringBoot.models.Product;

public interface ProductService {
    // Método abstracto --> son aquellos que se definen, pero no se implementan

    public List<Product> getProductDataBase();

}
