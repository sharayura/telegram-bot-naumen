package ru.yuri.telegrambotnaumen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ru.yuri.telegrambotnaumen.Service.EntitiesService;
import ru.yuri.telegrambotnaumen.entity.*;
import ru.yuri.telegrambotnaumen.repository.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class FillingTests {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Autowired
    private EntitiesService entitiesService;

    Map<String, Integer> order1 = new HashMap<>();

    {
        order1.put("Апельсиновый сок", 2);
        order1.put("Сладкий ролл 1", 3);
    }

    Map<String, Integer> order2 = new HashMap<>();

    {
        order2.put("Острый бургер 1", 1);
        order2.put("Энергетический напиток 1", 2);
        order2.put("Сладкий ролл 1", 4);
    }

    Map<String, Integer> order3 = new HashMap<>();

    {
        order3.put("Апельсиновый сок", 10);
        order3.put("Энергетический напиток 1", 2);
        order3.put("Сладкий ролл 1", 14);
    }

    @Test
    public void createTwoClients() {
        Client client1 = new Client();
        client1.setAddress("address1");
        client1.setExternalId(1L);
        client1.setFullName("fullName1");
        client1.setPhoneNumber("12345678901");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setAddress("address2");
        client2.setExternalId(1L);
        client2.setFullName("fullName2");
        client2.setPhoneNumber("12345678901");
        clientRepository.save(client2);
    }

    @Test
    public void creatingCategories() {
        var pizza = new Category();
        pizza.setName("Пицца");
        var rolls = new Category();
        rolls.setName("Роллы");
        var burgers = new Category();
        burgers.setName("Бургеры");
        var drinks = new Category();
        drinks.setName("Напитки");
        categoryRepository.save(pizza);
        categoryRepository.save(rolls);
        categoryRepository.save(burgers);
        categoryRepository.save(drinks);

        var rolls1 = new Category();
        rolls1.setName("Классические роллы");
        rolls1.setParent(rolls);
        categoryRepository.save(rolls1);

        var rolls2 = new Category();
        rolls2.setName("Запеченые роллы");
        rolls2.setParent(rolls);
        categoryRepository.save(rolls2);

        var rolls3 = new Category();
        rolls3.setName("Сладкие роллы");
        rolls3.setParent(rolls);
        categoryRepository.save(rolls3);

        var rolls4 = new Category();
        rolls4.setName("Наборы");
        rolls4.setParent(rolls);
        categoryRepository.save(rolls4);

        var burgers1 = new Category();
        burgers1.setName("Классические бургеры");
        burgers1.setParent(burgers);
        categoryRepository.save(burgers1);

        var burgers2 = new Category();
        burgers2.setName("Острые бургеры");
        burgers2.setParent(burgers);
        categoryRepository.save(burgers2);

        var drinks1 = new Category();
        drinks1.setName("Газированные напитки");
        drinks1.setParent(drinks);
        categoryRepository.save(drinks1);

        var drinks2 = new Category();
        drinks2.setName("Энергетические напитки");
        drinks2.setParent(drinks);
        categoryRepository.save(drinks2);

        var drinks3 = new Category();
        drinks3.setName("Соки");
        drinks3.setParent(drinks);
        categoryRepository.save(drinks3);

        var drinks4 = new Category();
        drinks4.setName("Другие");
        drinks4.setParent(drinks);
        categoryRepository.save(drinks4);

    }

    @Test
    public void creatingProducts() {
        var prod1 = new Product();
        prod1.setName("Апельсиновый сок");
        prod1.setDescription("drinks");
        prod1.setPrice(100d);
        prod1.setCategory(categoryRepository.findByName("Соки"));
        productRepository.save(prod1);

        var prod2 = new Product();
        prod2.setName("Энергетический напиток 1");
        prod2.setDescription("drinks");
        prod2.setPrice(150d);
        prod2.setCategory(categoryRepository.findByName("Энергетические напитки"));
        productRepository.save(prod2);

        var prod3 = new Product();
        prod3.setName("Сладкий ролл 1");
        prod3.setDescription("слааадко");
        prod3.setPrice(200d);
        prod3.setCategory(categoryRepository.findByName("Сладкие роллы"));
        productRepository.save(prod3);

        var prod4 = new Product();
        prod4.setName("Острый бургер 1");
        prod4.setDescription("оооооссстроооо");
        prod4.setPrice(300d);
        prod4.setCategory(categoryRepository.findByName("Острые бургеры"));
        productRepository.save(prod4);
    }

    @Test
    public void creatingClientOrders() {
        var clientOrder1 = new ClientOrder();
        clientOrder1.setClient(entitiesService.getClientByName("fullName1"));
        clientOrder1.setStatus(1);
        double sum = 0;
        for (Map.Entry<String, Integer> order : order1.entrySet()) {
            sum += order.getValue() * entitiesService.getProductByName(order.getKey()).getPrice();
        }
        clientOrder1.setTotal(sum);
        clientOrderRepository.save(clientOrder1);

        var clientOrder2 = new ClientOrder();
        clientOrder2.setClient(entitiesService.getClientByName("fullName2"));
        clientOrder2.setStatus(2);
        sum = 0;
        for (Map.Entry<String, Integer> order : order2.entrySet()) {
            sum += order.getValue() * entitiesService.getProductByName(order.getKey()).getPrice();
        }
        clientOrder2.setTotal(sum);
        clientOrderRepository.save(clientOrder2);

        var clientOrder3 = new ClientOrder();
        clientOrder3.setClient(entitiesService.getClientByName("fullName1"));
        clientOrder3.setStatus(1);
        sum = 0;
        for (Map.Entry<String, Integer> order : order3.entrySet()) {
            sum += order.getValue() * entitiesService.getProductByName(order.getKey()).getPrice();
        }
        clientOrder3.setTotal(sum);
        clientOrderRepository.save(clientOrder3);
    }

    @Test
    public void creatingOrderProducts() {
        orderToOrderProd(order1, 1l);
        orderToOrderProd(order2, 2l);
        orderToOrderProd(order3, 3l);
    }

    private void orderToOrderProd(Map<String, Integer> order, Long clientOrderId) {
        var clientOrder = clientOrderRepository.findById(clientOrderId).orElseThrow();
        for (Map.Entry<String, Integer> orderMap : order.entrySet()) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setClientOrder(clientOrder);
            orderProduct.setProduct(entitiesService.getProductByName(orderMap.getKey()));
            orderProduct.setCountProduct(orderMap.getValue());
            orderProductRepository.save(orderProduct);
        }
    }
}

