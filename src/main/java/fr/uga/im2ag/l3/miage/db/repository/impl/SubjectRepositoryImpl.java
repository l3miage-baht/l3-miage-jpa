package fr.uga.im2ag.l3.miage.db.repository.impl;

import fr.uga.im2ag.l3.miage.db.repository.api.SubjectRepository;
import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.model.Teacher;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

public class SubjectRepositoryImpl extends BaseRepositoryImpl implements SubjectRepository {

    public SubjectRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Subject entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Subject entity) {
        entityManager.remove(entity);
    }

    @Override
    public Subject findById(Long id) {
        // TODO
        return entityManager.find(Subject.class, id);
    }

    @Override
    public List<Subject> getAll() {
        // TODO
    	List<Subject> res;
    	String jpql = "select s from Subject s";
    	res = entityManager.createQuery(jpql, Subject.class).getResultList();
    	return res;
    }

    @Override
    public Collection<Teacher> findTeachers(Long id) {
        // TODO
    	Collection<Teacher> res = null;
    	String jpql = "select t from Teacher t where t.id = ?1";
    	res = entityManager.createQuery(jpql, Teacher.class).setParameter(1, id).getResultList();
        return res;
    }
}
