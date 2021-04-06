package model.repository;

import model.entities.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepo implements ICustomerRepo{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> get() {
        String queryGet = "select c from Customer as c";
        TypedQuery<Customer> query = entityManager.createQuery(queryGet, Customer.class);
        return query.getResultList();
    }
}
