package com.service.implementation;

import com.dao.interfaces.ProductDao;
import com.model.Product;
import com.model.ProductType;
import com.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void addProductToCart(int personId, int productId) {
        productDao.addProductToCart(personId, productId);
    }

    @Override
    public List<ProductType> getAllTypesOfProducts() {
        return productDao.getAllTypesOfProducts();
    }

    @Override
    public List<Product> getProductsByType(int typeId) {
        return productDao.getProductsByType(typeId);
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        return productDao.getAllProductsInCart(userId);
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        productDao.deleteFromCart(productId, userId);
    }

    @Override
    public void clearCart(int userId) {
        productDao.clearCart(userId);
    }
}
