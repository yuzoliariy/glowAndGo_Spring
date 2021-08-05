package com.service.interfaces;

import com.model.Product;
import com.model.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    void addProductToCart(final int personId, final int productId);

    List<ProductType> getAllTypesOfProducts();

    List<Product> getProductsByType(final int typeId);

    List<Product> getAllProductsInCart(final int userId);

    void deleteFromCart(final int productId, final int userId);

    void clearCart(final int userId);
}
