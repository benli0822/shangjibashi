//package com.menudesigner.sjbs.domain;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.logging.Logger;
//
//import static org.junit.Assert.assertNotNull;
//
///**
// * Created by JIN Benli on 10/11/14.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
//public class MockFactoryTest {
//    private static Logger logger = Logger.getLogger(MockFactoryTest.class.getName());
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Test
//    public void createActivityTest() {
//        logger.info("Starting creating activity test");
//        Activity activity = MockFactory.on(Activity.class).create(entityManager);
//        assertNotNull(activity);
//        assertNotNull(activity.getName());
//        assertNotNull(activity.getId());
//        entityManager.flush();
//    }
//
//    /**
//     * Overriding methods should call super.
//     */
//    @After
//    public void after() {
//        if (entityManager.getTransaction().isActive()) {
//            entityManager.getTransaction().rollback();
//        }
//    }
//
//}