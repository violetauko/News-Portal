package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() throws Exception{
        Users testUsers = setupNewUsers();
        assertEquals("Ellah",testUsers.getName());
    }

    @Test
    void setName() throws Exception{
        Users testUsers = setupNewUsers();
        testUsers.setName("Vio");
        assertNotEquals("Ellah",testUsers.getName());

    }

    @Test
    void getPosition() throws Exception{
        Users testUsers = setupNewUsers();
        assertEquals("CEO",testUsers.getPosition());
    }

    @Test
    void setPosition() throws Exception {
        Users testUsers = setupNewUsers();
        testUsers.setPosition("Secretary");
        assertNotEquals("CEO",testUsers.getPosition());
    }

    @Test
    void getRole() throws Exception {
        Users testUsers = setupNewUsers();
        assertEquals("Managing company",testUsers.getRole());

    }

    @Test
    void setRole() throws Exception {
        Users testUsers = setupNewUsers();
        testUsers.setRole("Supervision");
        assertNotEquals("Managing company",testUsers.getRole());
    }

    @Test
    void getDepartmentId() throws Exception {
        Users testUsers = setupNewUsers();
        assertEquals(1,testUsers.getDepartmentId());

    }

    @Test
    void setDepartmentId() throws Exception {
        Users testUsers = setupNewUsers();
        testUsers.setDepartmentId(2);
        assertNotEquals(1,testUsers.getDepartmentId());
    }

    @Test
    void testEquals() throws Exception{
        Users testUsers = setupNewUsers();
        Users testUsers2 = setupNewUsers();
        assertTrue(testUsers.equals(testUsers2));


    }
    public Users setupNewUsers(){
        return new Users("Ellah","CEO","Managing company",1);
    }

}