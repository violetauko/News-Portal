package dao;

import models.Department;
import models.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oNewsDaoTest {
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;
    private Connection conn;

    @BeforeEach
    void setUp() throws Exception{
        String connectionString = "jdbc:postgresql://localhost:5432/news_api_test";
        Sql2o sql2o = new Sql2o(connectionString, "violet", "3519ella");
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() throws Exception {
        conn.close();
    }

    @Test
    void add() throws Exception{
        News testNews = setupNews();
        int id =  newsDao.add(testNews);

        assertNotEquals(0, id);

    }

    @Test
    void getAll() throws Exception{
        News testNews = setupNews();
        newsDao.add(testNews);
        assertTrue(newsDao.getAll().size()>0);

    }

    @Test
    void deleteById() throws Exception{
        News testNews = setupNews();
        int id =newsDao.deleteById(testNews.getId());
        assertEquals(0, id);

    }

    @Test
    void clearAll() {
    }
    public News setupNews(){
        News news = new News("All employees should report to work on sunday",1);
            return news;
        }

    }
