package dao;

import models.Department;
import models.Users;
import interfaces.UsersDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oUsersDaoTest {
    private Connection conn;
    private Sql2oUsersDao usersDao;
    private Sql2oDepartmentDao departmentDao;

    @BeforeEach
    void setUp() throws Exception{
            String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/tables.sql'";
            Sql2o sql2o = new Sql2o(connectionString, "", "");
            usersDao = new Sql2oUsersDao(sql2o);
            departmentDao = new Sql2oDepartmentDao(sql2o);
            conn = sql2o.open();
        }

    @AfterEach
    void tearDown() throws Exception{
        conn.close();
    }

    @Test
    void add() throws Exception {
        Users testUsers = setupUsers();
        int id = testUsers.getId();
        usersDao.add(testUsers);
        assertNotEquals(id, testUsers.getId());
    }

    @Test
    void getAll() throws Exception {
        Users users = setupUsers();
        usersDao.add(users);
        assertTrue(usersDao.getAll().size()>0);

    }
    @Test
    void getAllUsersByDepartment() throws Exception {


//        Department testDepartment = setupDepartment();
//        Department testDepartment1 = setupDepartment();
//
//        Users users = setupUsersForDepartment(testDepartment);
//        Users users1 = setupUsersForDepartment(testDepartment1);
//        Users usersForDepartment1 = setupUsersForDepartment(testDepartment1);
//        assertEquals(2, usersDao.getAllUsersByDepartment(testDepartment.getId()).size());
    }

    @Test
    void deleteById() {
        Users testUsers = setupUsers();
        int id =usersDao.deleteById(testUsers.getId());
        assertEquals(0,id);
    }

    @Test
    void clearAll() {
        Users testUsers = setupUsers();
        Users testUsers1 = setupUsers();
        usersDao.clearAll();
        assertEquals(0, usersDao.getAll().size());
    }
    public Users setupUsers(){
        Users users = new Users("Ellah","CEO","Managing company",1);

        return users;
    }
    public Department setupDepartment() {
        Department department = new Department("Sales","scheduling advertisements",15);
        return department;
    }
    public Users setupUsersForDepartment(Department Department) {
        Users users = new Users("Ellah","CEO","Managing company",1);
        return users;
    }

}