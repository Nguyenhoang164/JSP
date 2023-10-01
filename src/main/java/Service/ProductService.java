package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void updateProduct(int id,Product product);
    void deleteProduct(int id);
    Product findById(int id);
    void createProduct(Product product);

}
