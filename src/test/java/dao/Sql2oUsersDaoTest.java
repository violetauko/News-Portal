package dao;

import models.Users;
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
        Users testUsers = setupUsers();
        Users testUsers1 = setupUsers();
        assertEquals(2, usersDao.getAll().size());


    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
        Users testUsers = setupUsers();
        Users testUsers1 = setupUsers();
        assertEquals(2, usersDao.getAll().size());
        usersDao.deleteById(testUsers.getId());
        assertEquals(1, usersDao.getAll().size());
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
        usersDao.add(users);
        return users;
    }

}