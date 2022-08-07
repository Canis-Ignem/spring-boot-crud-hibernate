package com.jon.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jon.crud.Entity.Employee;

@Repository
public class employeeDAOImpl implements EmployeeDAO {

	// define entity manage
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public employeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployees() {

		Session currentSession = this.entityManager.unwrap(Session.class);
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findByid(int employeeId) {

		Session currentSession = this.entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, employeeId);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = this.entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void deleteById(int employeeId) {

		Session currentSession = this.entityManager.unwrap(Session.class);

		Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", employeeId);
		query.executeUpdate();
	}

}
