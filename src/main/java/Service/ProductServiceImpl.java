package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    public static Map<Integer,Product> list ;
    static {
        list = new HashMap<>();
        list.put(1,new Product(1,"TV","18.000.000","con hang","SamSung"));
        list.put(2,new Product(2,"TV","18.000.000","con hang","SamSung"));
        list.put(3,new Product(3,"TV","18.000.000","con hang","SamSung"));
        list.put(4,new Product(4,"TV","18.000.000","con hang","SamSung"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(list.values());
    }

    @Override
    public Product findById(int id) {
        return list.get(id);
    }

    @Override
    public void createProduct(Product product) {
        list.put(product.getId(),product);
    }

    @Override
    public void deleteProduct(int id) {
        list.remove(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
       list.put(id,product);
    }
}
