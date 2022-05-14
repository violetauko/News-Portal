package dao;

import models.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;
    private Connection conn;

    @BeforeEach
    void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/tables.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() throws Exception {
        conn.close();
    }

    @Test
    void add() throws Exception{
        News testNews = setupNewNews();
        int id = testNews.getId();
        newsDao.add(testNews);
        assertNotEquals(id, testNews.getId());

    }

    @Test
    void getAll() throws Exception{
        News testNews = setupNewNews();
        newsDao.add(testNews);
        assertEquals(1,newsDao.getAll().size());

    }

    @Test
    void deleteById() {
    }

    @Test
    void clearAll() {
    }
    public News setupNewNews(){
        return new News("All employees should report to work on sunday",1);

    }

}