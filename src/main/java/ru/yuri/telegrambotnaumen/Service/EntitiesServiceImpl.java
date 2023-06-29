package ru.yuri.telegrambotnaumen.Service;

import ru.yuri.telegrambotnaumen.entity.Client;
import ru.yuri.telegrambotnaumen.entity.ClientOrder;
import ru.yuri.telegrambotnaumen.entity.Product;

import java.util.List;

public class EntitiesServiceImpl implements EntitiesService{
    @Override
    public Client getClientByName(String name) {
        return null;
    }

    @Override
    public List<ClientOrder> getOrdersByStatus(Integer status) {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategoryId(Long id) {
        return null;
    }

    @Override
    public List<ClientOrder> getClientOrdersByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsByClientId(Long id) {
        return null;
    }

    @Override
    public List<Product> getTopPopularProducts(Integer top) {
        return null;
    }
}
