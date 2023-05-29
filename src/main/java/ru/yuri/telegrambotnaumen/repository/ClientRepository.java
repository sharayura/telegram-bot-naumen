package ru.yuri.telegrambotnaumen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.yuri.telegrambotnaumen.entity.Client;

@RepositoryRestResource(collectionResourceRel = "clients", path = "clients" )
public interface ClientRepository extends JpaRepository<Client, Long> {
}
