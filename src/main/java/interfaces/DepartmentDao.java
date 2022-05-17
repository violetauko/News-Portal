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

    Department findById(int id);

    //delete
    int deleteById(int id);
    void clearAll();
}
