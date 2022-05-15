package interfaces;

import models.Department;
import models.Users;

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
    void deleteById(int id);
    void clearAll();
}
