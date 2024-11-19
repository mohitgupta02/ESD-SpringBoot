package com.esd.prodcrud.repo;

import com.esd.prodcrud.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {


    @Query(value = "SELECT * FROM product where  price >= 15 and price <=30 order by price limit 2",nativeQuery = true)
    List<Product> findTop2ProductsInPriceRange();
}
