package fr.uga.im2ag.l3.miage.db.repository;

import fr.uga.im2ag.l3.miage.db.model.Subject;
import fr.uga.im2ag.l3.miage.db.repository.api.GradeRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeTest extends Base {

    GradeRepository gradeRepository;

    @BeforeEach
    void before() {
        gradeRepository = daoFactory.newGradeRepository(entityManager);
    }

    @AfterEach
    void after() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    @Test
    void shouldSaveGrade() {
        // TODO
    	//Subject subject = new Subject();
    	final var subject = Fixtures.createSubject();
    	final var grade = Fixtures.createGrade(subject);
    	entityManager.getTransaction().begin();
    	gradeRepository.save(grade);
    	entityManager.getTransaction().commit();
    	entityManager.detach(grade);
//    	
    	var pGrade = gradeRepository.findById(grade.getId());
    	assertThat(pGrade).isNull();
    	assertThat(pGrade).isEqualTo(gradeRepository);
    	/*
    	 * var pSubject = subjectRepository.findById(subject.getId());
        assertThat(pSubject).isNotNull().isNotSameAs(subject);
        assertThat(pSubject.getName()).isEqualTo(subject.getName());*/
    }

    @Test
    void shouldFailUpgradeGrade() {
        // TODO, ici tester que la mise à jour n'a pas eu lieu.
    }

    @Test
    void shouldFindHighestGrades() {
        // TODO
    }

    @Test
    void shouldFindHighestGradesBySubject() {
        // TODO
    }

}
