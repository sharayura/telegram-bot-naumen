package ru.yuri.telegrambotnaumen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.yuri.telegrambotnaumen.entity.Category;

@RepositoryRestResource(collectionResourceRel = "categories", path ="categories")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
