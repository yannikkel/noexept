package repository;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductRepository {
    private Product[] products = new Product[0];


    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        int i = 0;
        for (Product product : products) {
            if (product.getId() == id) {
                return products[i];
            }
            i++;
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int i = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[i] = product;
                i++;
            }
        }
        products = tmp;
    }


}
