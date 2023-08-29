package com.example.demojphibernate01.repository;

import com.example.demojphibernate01.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository  {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Employee insertEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    public Employee findEmployeeById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void removeEmployeeById(Long id) {
        Employee employee = findEmployeeById(id);
        entityManager.remove(employee);
    }

    @Transactional
    public Employee detachState(Employee employee) {
        entityManager.detach(employee);
        employee.setFirstName("new firstname");
        employee.setLastName("new lastname");
        entityManager.merge(employee);
//        entityManager.flush();
        return employee;
    }
}
