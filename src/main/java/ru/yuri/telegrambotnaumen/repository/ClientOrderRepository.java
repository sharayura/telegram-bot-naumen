package ru.yuri.telegrambotnaumen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.yuri.telegrambotnaumen.entity.ClientOrder;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "clientOrders", path = "clientOrders")
public interface ClientOrderRepository extends JpaRepository<ClientOrder, Long> {
    List<ClientOrder> findAllByStatus(Integer status);
    List<ClientOrder> findAllByClientFullName(String name);
}
