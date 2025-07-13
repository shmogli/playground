package com.hackerrank.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class SampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}

@RestController
@RequestMapping("/")
class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("filter/price/{min}/{max}")
    public ResponseEntity<List<Product>> filterByPrice(@PathVariable int min, @PathVariable int max) {
        List<Product> filtered = productService.filterByPrice(min, max);
        if (filtered.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }

    @GetMapping("sort/price")
    public ResponseEntity<List<String>> sortByPrice() {
        List<String> sortedNames = productService.sortByPrice();
        return new ResponseEntity<>(sortedNames, HttpStatus.OK);
    }
}

@Service
class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> filterByPrice(int min, int max) {
        return productRepository.findAll().stream()
                .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                .collect(Collectors.toList());
    }

    public List<String> sortByPrice() {
        return productRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .map(Product::getItem)
                .collect(Collectors.toList());
    }
}

@Repository
class ProductRepository {
    private List<Product> products = new ArrayList<>();
    @PostConstruct
    public void init() {
        products.add(new Product("74001755", "Ball Gown", "Full Body Outfits", 3548, 7, 1));
        products.add(new Product("74002423", "Shawl", "Accessories", 1299, 10, 1));
        // Add more products if needed
    }

    public List<Product> findAll() {
        return products;
    }
}

class Product {
    private String barcode;
    private String item;
    private String category;
    private int price;
    private int discount;
    private int available;

    public Product(String barcode, String item, String category, int price, int discount, int available) {
        this.barcode = barcode;
        this.item = item;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.available = available;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getItem() {
        return item;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getAvailable() {
        return available;
    }
}