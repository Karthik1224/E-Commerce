package com.example.springmock.Services;

import com.example.springmock.Models.Order;
import com.example.springmock.Models.Product;
import com.example.springmock.Repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    public String addOrder(Order order)
    {
         List<Product> productList = order.getProductList();
         List<Product> productList1 = new ArrayList<>();
         for(Product p:productList)
         {
             if(p.getName().equals("A"))
             {
                 productList1.add(p);
             }
         }


         order.setProductList(productList1);
         orderRepo.save(order);
         return "added";

    }

    public Product mostOrderedProduct()
    {
        List<Order>optionalOrder = orderRepo.findAll();
        if(optionalOrder.isEmpty()) return null;
        Product ans = null;
        int maxCount=0;
        for(Order order:optionalOrder)
        {
              List<Product>productList = order.getProductList();
              for(int i=0; i< productList.size(); i++)
              {
                   Product p = productList.get(i);
                   Integer id = p.getProductId();
                   int count=1;
                  for(int j=i+1; j< productList.size(); j++)
                  {
                      Product p1 = productList.get(j);
                      if(p1.getProductId()==id)
                      {
                          count++;
                      }
                  }
                  if(count>maxCount)
                  {
                      maxCount = count;
                      ans = p;
                  }

              }
        }
        return ans;

    }
}
