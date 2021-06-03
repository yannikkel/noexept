package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Book One", 100, "Author One");
    private Book book2 = new Book(2, "Book Two", 200, "Author Two");
    private Book book3 = new Book(3, "Smartphone Book", 300, "Author Manufacturer");
    private Smartphone smartphone1 = new Smartphone(4, "Smartphone One", 1000, "Manufacturer One");
    private Smartphone smartphone2 = new Smartphone(5, "Smartphone Two", 2000, "Manufacturer Two");
    private Smartphone smartphone3 = new Smartphone(6, "Smartphone Book", 3000, "Author Manufacturer");

    @BeforeEach
    public void setUp() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
    }

    @Test
    public void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("book one");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("author two");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("smartphone one");
        Product[] expected = new Product[]{smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("manufacturer two");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBothByName() {
        Product[] actual = manager.searchBy("smartphone book");
        Product[] expected = new Product[]{book3, smartphone3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNothing() {
        Product[] actual = manager.searchBy("what");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);
    }
}
