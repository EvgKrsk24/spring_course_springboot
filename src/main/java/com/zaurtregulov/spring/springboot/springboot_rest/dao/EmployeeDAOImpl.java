package com.zaurtregulov.spring.springboot.springboot_rest.dao;



import com.zaurtregulov.spring.springboot.springboot_rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
//import org.hibernate.Session;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        return session.createQuery(" from Employee", Employee.class).getResultList();

        Query  query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee=entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }

    @Override
    public Employee getEmployeeById(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        return session.get(Employee.class, id);
        Employee employee = entityManager.find(Employee.class, id);
        return employee;

    }
    @Transactional
    @Override
    public void deleteEmployee(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        ////Query<Employee> query = session.createQuery("delete from Employee where id = :empId");
//        Query query = session.createQuery("delete from Employee where id = :empId");
//        query.setParameter("empId", id);
//        query.executeUpdate();

        Query query = entityManager.createQuery("delete from Employee " +
                "where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();


    }
}
