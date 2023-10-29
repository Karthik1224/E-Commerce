package com.example.springmock.Services;

import com.example.springmock.Models.Product;
import com.example.springmock.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public String addProduct(Product product)
    {
         productRepo.save(product);
         return "added";
    }

    public Product getMaxPriceProduct(String category)
    {
            List<Product> productList = productRepo.findProductsByCategory(category);
            double curPrice = 0;
            Product ans = null;
            for(Product p:productList)
            {
                 if(p.getPrice()>curPrice)
                 {
                     ans = p;
                     curPrice = p.getPrice();
                 }
            }
            return ans;
    }
}
