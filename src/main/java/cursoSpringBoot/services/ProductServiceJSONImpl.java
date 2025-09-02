package cursoSpringBoot.services;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cursoSpringBoot.models.Product;
import java.io.IOException;
import java.util.List;

//@Primary se quita porque se implemento Qualifier 
//@Service("jsonResourceService") --> solo cuando se ocupa @Qualifier
@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
public class ProductServiceJSONImpl implements ProductService {

    @Override
    public List<Product> getProductDataBase() {
        List<Product> productList;

        // IMPORTANTE
        // LA ENTIDAD O POJO DEBE TENER UN CONTRUCTOR VACIÓ, YA QUE JACKSON ASIGNA LOS
        // VALORES DESERIALIZADOS
        // A LOS ATRIBUTOS DE LA CLASE MEDIANTE MÉTODO SETTERS

        // manejo de errores, en caso de que exista un error al abrir el archivo
        try {
            // ObjectMapper() --> función de la biblioteca jackson
            productList = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/products.json"),
                            new TypeReference<List<Product>>() {
                            });

            return productList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
