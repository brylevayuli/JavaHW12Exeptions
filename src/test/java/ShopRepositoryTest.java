import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShopRepositoryTest {

    @Test
    void successfulRemoveById() {
        ShopRepository shopRepository = new ShopRepository();

        Product product = new Product(15, "Холодильник", 35_000);

        shopRepository.add(product);
        shopRepository.remove(15);

        Product[] actual = shopRepository.findAll();
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void successfulRemoveByIdMultProducts() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(15, "Холодильник", 35_000);
        Product product2 = new Product(20, "Кошки", 50_000);
        Product product3 = new Product(30, "Мышки", 10_000);
        Product product4 = new Product(10, "Пельмешки", 500);


        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);

        shopRepository.remove(30);

        Product[] actual = shopRepository.findAll();
        Product[] expected = new Product[]{product1, product2, product4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void nonExistentId() {
        ShopRepository shopRepository = new ShopRepository();

        Product product = new Product(15, "Холодильник", 35_000);
        shopRepository.add(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(404);
        });
    }
}
