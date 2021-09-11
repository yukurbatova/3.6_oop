package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(122, "Two captains", 1450, "Veniamin Kaverin", 715, 2015);
    private Book secondBook = new Book(345, "Purple ball", 950, "Kir Bulychev", 244, 2001);

    @BeforeEach
    void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void shouldRemoveByExistId() {
        repository.removeById(122);

        Product[] expected = new Product[]{secondBook};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundException() {

        assertThrows(NotFoundException.class, () -> {
            repository.removeById(12);
        });
    }
}