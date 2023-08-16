package ru.yuri.telegrambotnaumen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.yuri.telegrambotnaumen.entity.Product;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends JpaRepository<Product, Long> {
    String GET_TOP_POPULAR_QUERY = "select o.product from OrderProduct as o group by o.product.id order by sum(o.countProduct) desc";
    @Query(value = GET_TOP_POPULAR_QUERY)
    List<Product> getTopPopular();

    List<Product> findProductsByCategoryId(Long id);

    String GET_PRODUCTS_BY_CLIENT_ID_QUERY = "select distinct o.product from OrderProduct o where o.clientOrder.client.id = ?1";
    @Query(value = GET_PRODUCTS_BY_CLIENT_ID_QUERY)
    List<Product> getProductByClientId(Long id);
}
