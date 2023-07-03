package ru.yuri.telegrambotnaumen.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yuri.telegrambotnaumen.Service.EntitiesService;
import ru.yuri.telegrambotnaumen.entity.Client;
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
}
