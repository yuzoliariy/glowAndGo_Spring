package com.dao.interfaces;

import com.model.Product;
import com.model.ProductType;

import java.util.List;

public interface ProductDao extends Dao<Product> {

    void addProductToCart(final int personId, final int productId);

    List<Product> getProductsByType(final int typeId);

    List<ProductType> getAllTypesOfProducts();

    List<Product> getAllProductsInCart(final int userId);

    void deleteFromCart(final int productId, final int userId);

    void clearCart(final int userId);
}
