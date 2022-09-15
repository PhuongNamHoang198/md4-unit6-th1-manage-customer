package repository;

import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
// @Transactional là một annotation trong spring data
// nó sẽ được sử dụng để quản lý các transaction trong spring data
public class CustomerRepository implements ICustomerRepository {
@PersistenceContext
// @PersistenceContext là một annotation trong hibernate
// nó sẽ được sử dụng để quản lý các session trong hibernate
private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer  c", Customer.class);

    return query.getResultList();}
 public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c where c.id=:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

 }
//    @Override
//    public void save(Customer customer) {
//        if (customer.getId() != null) {
//            em.merge(customer);
//        } else {
//            em.persist(customer);
//        }
//    }
    public void save(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        }else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
