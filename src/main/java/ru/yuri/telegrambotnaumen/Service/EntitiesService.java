package ru.yuri.telegrambotnaumen.Service;

import ru.yuri.telegrambotnaumen.entity.Client;
import ru.yuri.telegrambotnaumen.entity.ClientOrder;
import ru.yuri.telegrambotnaumen.entity.Product;

import java.util.List;

/**
 * Сервис для работы с сущностями телеграмм-бота
 */
public interface EntitiesService
{
    /**
     * Получить клиента по его имени
     * @param name имя клиента
     */
    Client getClientByName(String name);

    /**
     * Получить заказ по его статусу
     * @param status статус заказа
     */
    List<ClientOrder> getOrdersByStatus(Integer status);

    /**
     * Получить товар по его названию
     * @param name название товара
     */
    Product getProductByName(String name);

    /**
     * Получить список товаров в категории
     * @param id идентификатор категории
     */
    List<Product> getProductsByCategoryId(Long id);

    /**
     * Получить список заказов клиента по его имени
     * @param name имя клиента
     */
    List<ClientOrder> getClientOrdersByName(String name);

    /**
     * Получить список всех товаров во всех заказах клиента
     * @param id идентификатор клиента
     */
    List<Product> getProductsByClientId(Long id);

    /**
     * Получить указанное кол-во самых популярных (наибольшее
     * количество штук в заказах) товаров среди клиентов
     * @param top кол-во товаров
     */
    List<Product> getTopPopularProducts(Integer top);
}

