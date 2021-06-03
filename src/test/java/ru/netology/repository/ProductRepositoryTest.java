package repository;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import exception.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private Book book1 = new Book(1, "Book One", 100, "Author One");
    private Book book2 = new Book(2, "Book Two", 200, "Author Two");
    private Book book3 = new Book(3, "Smartphone Book", 300, "Author Manufacturer");

    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(2);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    @Disabled
    void shouldRemoveById10() {
        repository.removeById(10);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenRemoveById() {
        assertThrows(NotFoundException.class, () -> repository.removeById(10));
    }
}
