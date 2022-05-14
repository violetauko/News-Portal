package interfaces;

import models.Department;
import models.Users;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);

    //read
    List<Department> getAll();
    // List<Users> getAllUsersForADepartment(int id);
    Department findById(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
