package ru.yuri.telegrambotnaumen.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yuri.telegrambotnaumen.Service.EntitiesService;
import ru.yuri.telegrambotnaumen.entity.Client;
import ru.yuri.telegrambotnaumen.entity.ClientOrder;
import ru.yuri.telegrambotnaumen.entity.Product;

import java.util.List;

@RestController
public class ApplicationRestController {

    private final EntitiesService entitiesService;

    public ApplicationRestController(EntitiesService entitiesService) {
        this.entitiesService = entitiesService;
    }

    @GetMapping(value = "/rest/clients", params = "name")
    public ResponseEntity<Client> getClientByName(@RequestParam String name) {
        return ResponseEntity.ok(entitiesService.getClientByName(name));
    }

    @GetMapping(value = "/rest/topPopularProducts", params = "top")
    public ResponseEntity<List<Product>> getTopPopularProducts(@RequestParam Integer top) {
        return ResponseEntity.ok(entitiesService.getTopPopularProducts(top));
    }

    @GetMapping(value = "/rest/products", params = "name")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        return ResponseEntity.ok(entitiesService.getProductByName(name));
    }

    @GetMapping(value = "/rest/listClientProducts", params = "clientId")
    public ResponseEntity<List<Product>> getProductsByClientId(@RequestParam Long clientId) {
        return ResponseEntity.ok(entitiesService.getProductsByClientId(clientId));
    }

    @GetMapping(value = "/rest/orders", params = "status")
    public ResponseEntity<List<ClientOrder>> getOrdersByStatus(@RequestParam Integer status) {
        return ResponseEntity.ok(entitiesService.getOrdersByStatus(status));
    }

    @GetMapping(value = "/rest/products", params = "categoryId")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@RequestParam Long categoryId) {
        return ResponseEntity.ok(entitiesService.getProductsByCategoryId(categoryId));
    }

    @GetMapping(value = "/rest/listClientOrders", params = "clientName")
    public ResponseEntity<List<ClientOrder>> getClientOrdersByName(@RequestParam String clientName) {
        return ResponseEntity.ok(entitiesService.getClientOrdersByName(clientName));
    }
}
