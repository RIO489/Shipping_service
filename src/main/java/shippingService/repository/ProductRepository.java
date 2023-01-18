package shippingService.repository;

import org.hibernate.service.spi.ServiceException;
import shippingService.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {
    private List<Product> productList = new ArrayList<>();
    private Long id = 0L;

    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    public Product save(final Product product){
        ++id;
        product.setId(id);
        productList.add(product);

        return product;
    }

    public Product findById(final Long id){
        return productList.stream()
                .filter(e->e.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new ServiceException("Product can not be find by id:" + id));
    }

    public void delete(final Long id){
        productList = productList.stream()
                .filter(e-> !e.getId().equals(id))
                .collect(Collectors.toList());
    }

    public Product update(final Product product){
        final Product saved = findById(product.getId());

        saved.setName(product.getName());
        saved.setDescription(product.getDescription());
        saved.setPrice(product.getPrice());

        return saved;
    }
}
