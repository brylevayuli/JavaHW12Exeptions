import org.example.AlreadyExistsException;
import org.example.NotFoundException;
import org.example.Product;
import org.example.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ShopRepositoryTest {

    @Test
    void successfulRemoveById() {
        ShopRepository repo = new ShopRepository();

        Product product = new Product(15, "Холодильник", 35_000);

        repo.add(product);
        repo.remove(15);

        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void successfulRemoveByIdMultipleProducts() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(15, "Холодильник", 35_000);
        Product product2 = new Product(20, "Кошки", 50_000);
        Product product3 = new Product(30, "Мышки", 10_000);
        Product product4 = new Product(10, "Пельмешки", 500);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        repo.remove(30);

        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{product1, product2, product4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByNonExistentId() {
        ShopRepository repo = new ShopRepository();

        Product product = new Product(15, "Холодильник", 35_000);
        repo.add(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(404);
        });
    }

    @Test
    void successfulAdditionByIdMultipleProducts() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(15, "Холодильник", 35_000);
        Product product2 = new Product(20, "Кошки", 50_000);
        Product product3 = new Product(30, "Мышки", 10_000);
        Product product4 = new Product(10, "Пельмешки", 500);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);


        Product[] actual = repo.findAll();
        Product[] expected = new Product[]{product1, product2, product3, product4};

        assertArrayEquals(expected, actual);
    }

    @Test
    void additionByExistentId() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(15, "Холодильник", 35_000);
        Product product2 = new Product(20, "Кошки", 50_000);
        Product product3 = new Product(30, "Мышки", 10_000);
        Product product4 = new Product(10, "Пельмешки", 500);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product2);
        });
    }
}


