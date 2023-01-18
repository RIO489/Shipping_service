package shippingService.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingService.dto.ProductDTO;
import shippingService.service.ProductService;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping
    public ProductDTO findById(@PathVariable final Long id){
        return productService.findById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody final ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody final ProductDTO productDTO) {
        return productService.update(productDTO);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable final Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping({"/super"})
    String home() {
        final String url = "jdbc:mysql://localhost:3306/shop";
        final String name = "root";
        final String password = "polapamax";
        final String testName = "Hlib";
        final String testDesc = "ababa";
        final int testPrice = 10;

        try {
            final Connection conn = DriverManager.getConnection(url, name, password);

            try {
                final Statement statement = conn.createStatement();
                statement.executeUpdate("insert into test()" +  " value(6, " + testName+"," + testDesc+"," + testPrice);
            } catch (final Throwable var8) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (final Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (conn != null) {
                conn.close();
            }

            return "Hello world";
        } catch (final SQLException var9) {
            throw new RuntimeException(var9);
        }
    }
}
