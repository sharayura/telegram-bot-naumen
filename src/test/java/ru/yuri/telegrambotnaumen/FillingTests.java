package ru.yuri.telegrambotnaumen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yuri.telegrambotnaumen.entity.Category;
import ru.yuri.telegrambotnaumen.entity.Client;
import ru.yuri.telegrambotnaumen.repository.CategoryRepository;
import ru.yuri.telegrambotnaumen.repository.ClientRepository;

@SpringBootTest
public class FillingTests {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
}

