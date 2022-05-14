package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() throws Exception{
        Department testDepartment = setupNewDepartment();
        assertEquals("Sales", testDepartment.getName());
    }

    @Test
    void setName() throws Exception {
        Department testDepartment = setupNewDepartment();
        testDepartment.setName("Production");
        assertNotEquals("Sales",testDepartment.getName());

    }

    @Test
    void getDescription() throws Exception {
        Department testDepartment = setupNewDepartment();
        assertEquals("scheduling advertisements", testDepartment.getDescription());

    }

    @Test
    void setDescription() throws Exception {
        Department testDepartment = setupNewDepartment();
        testDepartment.setDescription("supports the General Manager");
        assertNotEquals("scheduling advertisements",testDepartment.getName());

    }

    @Test
    void getTotalEmployees() throws Exception{
        Department testDepartment = setupNewDepartment();
        assertEquals(15, testDepartment.getTotalEmployees());

    }

    @Test
    void setTotalEmployees() throws Exception{
        Department testDepartment = setupNewDepartment();
        testDepartment.setTotalEmployees(20);
        assertNotEquals(15,testDepartment.getTotalEmployees());

    }

    @Test
    void Equals() throws Exception{
        Department testDepartment = setupNewDepartment();
        Department testDepartment2 = setupNewDepartment();
        assertTrue(testDepartment.equals(testDepartment2));


    }
    public Department setupNewDepartment() {
        return new Department("Sales","scheduling advertisements",15);
    }
}