package com.dao.implementation;

import com.dao.interfaces.ProductDao;
import com.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao {
 private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getAll() {
         return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void add(final Product product) {
        sessionFactory.getCurrentSession().persist(product);
    }

    @Override
    public Product get(final int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void update(final Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public void delete(final int id) {
        sessionFactory.getCurrentSession().remove(id);
    }

    @Override
    public void addProductToCart(int personId, int productId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("insert into cart(userid, productid) values (?,?)")
                .setParameter(1, personId)
                .setParameter(2, productId).executeUpdate();
    }

    @Override
    public List getAllTypesOfProducts() {
        return sessionFactory.getCurrentSession().createQuery("from ProductType").list();
    }

    @Override
    public List<Product> getProductsByType(final int typeId) {
        Query<Product> query = sessionFactory.getCurrentSession()
                .createQuery("from Product where productTypeId="+typeId);

        return query.list();
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        Query<Product> query = sessionFactory.getCurrentSession()
                .createNativeQuery("select*from products inner join cart  on id = productId where userId=?")
                .setParameter(1,userId);
        return query.list();
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
sessionFactory.getCurrentSession()
        .createNativeQuery("delete from cart where productId = ? and userId = ?")
        .setParameter(1,productId)
        .setParameter(2,userId).executeUpdate();
    }

    @Override
    public void clearCart(int userId) {
        sessionFactory.getCurrentSession()
                .createNativeQuery("delete from cart where userId = ?")
                .setParameter(1,userId).executeUpdate();
    }
}
