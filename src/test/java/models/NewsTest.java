package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getGeneralNews() throws Exception{
        News testNews = setupNewNews();
        assertEquals("All employees should report to work on sunday", testNews.getGeneralNews());

    }

    @Test
    void setGeneralNews() throws Exception{
        News testNews = setupNewNews();
        testNews.setGeneralNews("No employee should report to work on sunday");
        assertNotEquals("All employee should report to work on sunday", testNews.getGeneralNews());
    }

    @Test
    void getDepartmentId() throws Exception{
        News testNews = setupNewNews();
        assertEquals(1,testNews.getDepartmentId());

    }

    @Test
    void setDepartmentId() throws Exception{
        News testNews = setupNewNews();
        testNews.setDepartmentId(2);
        assertNotEquals(1, testNews.getDepartmentId());
    }

    public News setupNewNews(){
        return new News("All employees should report to work on sunday",1);
    }
}