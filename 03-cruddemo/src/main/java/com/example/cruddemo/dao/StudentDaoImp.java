package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao{
    // req to connect to DB
    private EntityManager entityManager;

    //constructor to inject entityManager
    @Autowired
    public StudentDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    //no need for Transactional as it is just a query
    // returns found object or null if not found
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);

    }

    @Override
    public List<Student> findAll() {
        // create query using entitymanager. It uses JPQL which is similar to SQL
        // FROM Student refers to the entity in JAVA, not the SQL table
        //lastName refers to Java entity fields and not column name
        TypedQuery query= entityManager.createQuery("FROM Student order by lastName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lName) {
        // Pass parameter in query with :name and use setParameter to set the value of the parameter
        TypedQuery<Student> query=entityManager.createQuery("FROM Student where lastName=:lName",Student.class);
        query.setParameter("lName",lName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public Integer updateMultiple() {
        int i = entityManager.createQuery("UPDATE Student SET firstName='Updated1'").executeUpdate();
        return i;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student temp=entityManager.find(Student.class,1);
        entityManager.remove((temp));
    }

    @Override
    @Transactional
    public Integer multipleDelete() {
        return entityManager.createQuery("Delete from Student where email='abc@xyz.com'").executeUpdate();
    }

}
