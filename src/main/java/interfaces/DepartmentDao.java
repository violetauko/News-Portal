package interfaces;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //create
    int add(Department department);

    //read
    List<Department> getAll();
    // List<Users> getAllUsersForADepartment(int id);

    //update
    //omit for now

    //delete
    int deleteById(int id);
    void clearAll();
}
