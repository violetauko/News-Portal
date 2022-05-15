package dao;

import models.Department;
import models.Users;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oDepartmentDaoTest {
    private Connection conn;
    private Sql2oDepartmentDao departmentDao;
    private Sql2oNewsDao newsDao;
    private Sql2oUsersDao usersDao;


    @BeforeEach
    void setUp() throws Exception{
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/tables.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        departmentDao = new Sql2oDepartmentDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    void tearDown() throws Exception{
        conn.close();
    }

    @Test
    void add() throws Exception{
        Department testDepartment = setupDepartment();
        int id = departmentDao.add(testDepartment);
        assertNotEquals(0, id);

    }

    @Test
    void getAll() throws Exception{
        Department testDepartment = setupDepartment();
        Department testDepartment1 = setupDepartment();
        assertTrue(departmentDao.getAll().size()>0);
    }

    @Test
    void deleteById() throws Exception{
        Department testDepartment = setupDepartment();
       int id = departmentDao.deleteById(testDepartment.getId());
        assertEquals(0,id);
    }

    @Test
    void clearAll() throws Exception{
        Department testDepartment = setupDepartment();
        Department testDepartment1 = setupDepartment();
        departmentDao.clearAll();
        assertEquals(0, departmentDao.getAll().size());
    }
    public Department setupDepartment() {
        Department department = new Department("Sales","scheduling advertisements",15);
        departmentDao.add(department);
        return department;
    }
}