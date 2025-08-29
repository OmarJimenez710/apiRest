package cursoSpringBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cursoSpringBoot.services.ProductService;
import cursoSpringBoot.services.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

    /*
     * POLOMORFISMO DINAMICO
     * Estamos creando un objeto de tipo ProductService (interfaz)
     * Pero estamos igualandolo a la implementación de esa interfaz
     * (ProductServiceImp)
     * Lo siguiente, aunque NO esta mal, si se genera un fuerte
     * acoplamiento entre la interfaz y el servicio, y lo que buscamos
     * es reducir lo fuertemente acoplado y desacoplar
     */
    // ProductService productService = new ProductServiceImpl();

    @Autowired // notación que genera la inyección de dependencias
    private ProductService productService; // se genera una composición

    @GetMapping
    public ResponseEntity<?> getProductList() {
        return ResponseEntity.ok(productService.getProductDataBase());
    }
}
