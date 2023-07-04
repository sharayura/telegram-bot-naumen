package ru.yuri.telegrambotnaumen.Service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yuri.telegrambotnaumen.entity.Client;
import ru.yuri.telegrambotnaumen.entity.ClientOrder;
import ru.yuri.telegrambotnaumen.entity.Product;
import ru.yuri.telegrambotnaumen.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class EntitiesServiceImpl implements EntitiesService{

    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;
    private final ClientOrderRepository clientOrderRepository;
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    public EntitiesServiceImpl(ClientRepository clientRepository, CategoryRepository categoryRepository, ClientOrderRepository clientOrderRepository, OrderProductRepository orderProductRepository, ProductRepository productRepository) {
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
        this.clientOrderRepository = clientOrderRepository;
        this.orderProductRepository = orderProductRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Client getClientByName(String name) {
        Client exampleClient = new Client();
        exampleClient.setFullName(name);
        return clientRepository.findOne(Example.of(exampleClient)).orElse(null);
    }

    @Override
    public List<ClientOrder> getOrdersByStatus(Integer status) {
        return clientOrderRepository.findAllByStatus(status);
    }

    @Override
    public Product getProductByName(String name) {
        Product exampleProduct = new Product();
        exampleProduct.setName(name);
        return productRepository.findOne(Example.of(exampleProduct)).orElse(null);
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.findProductsByCategoryId(id);
    }

    @Override
    public List<ClientOrder> getClientOrdersByName(String name) {
        return clientOrderRepository.findAllByClientFullName(name);
    }

    @Override
    public List<Product> getProductsByClientId(Long id) {
        return productRepository.getProductByClientId(id);
    }

    @Override
    public List<Product> getTopPopularProducts(Integer top) {
        return productRepository.getTopPopular().subList(0, top);
    }
}
