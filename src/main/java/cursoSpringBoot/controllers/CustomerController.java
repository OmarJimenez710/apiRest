package cursoSpringBoot.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import cursoSpringBoot.models.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private List<Customer> customerList = new ArrayList<>(Arrays.asList(
            new Customer(1, "customer1", "user1", "password1"),
            new Customer(2, "customer2", "user2", "password2"),
            new Customer(3, "customer2", "user2", "password3"),
            new Customer(4, "customer2", "user2", "password4"),
            new Customer(5, "customer2", "user2", "password5")));

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerList() {
        // return customerList;
        return ResponseEntity.ok(customerList);
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable int id) {
        for (Customer c : customerList) {
            if (c.getId() == id) {
                // return c;
                return ResponseEntity.ok(c);
            }
        }

        // return null; // practica no recomendada
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el id: " + id);
    }

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        customerList.add(customer);

        // return ResponseEntity.status(HttpStatus.CREATED)
        // .body("Usuario creado correctamente con id: " + customer.getId());

        // construimos la url del nuevo recurso
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        // return ResponseEntity.created(location).build(); Da una respuesta sin
        // contenido, pero en los headers se muestra la URI

        // BUENA PRACTICA EN EL DIEÑO DE APLICACIONES RESTFUL
        // mandar la URI del recurso creado en cabezara y el recurso creado en la
        // respuesta
        return ResponseEntity.created(location).body(customer);
    }

    // @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        for (Customer c : customerList) {
            if (c.getId() == customer.getId()) {
                c.setId(customer.getId());
                c.setName(customer.getName());
                c.setUserName((customer.getUserName()));
                c.setPassword(customer.getPassword());

                return ResponseEntity.ok("Cliente modificado con éxito con id: " + customer.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Cliente con id " + customer.getId() + " no encontrado");
    }

    // @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        for (Customer c : customerList) {
            if (c.getId() == id) {
                customerList.remove(c);
                return ResponseEntity.ok("Cliente eliminado correctamente");
            }
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente con id " + id + " no encontrado");
    }
}
