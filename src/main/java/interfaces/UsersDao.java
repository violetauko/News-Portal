package interfaces;

import models.Users;

import java.util.List;

public interface UsersDao {
    //create
    int add (Users users);

    //read
    List<Users> getAll();
    // List<Department> getAllDepartmentsForAUser(int departmentId);
  //List<getAllUsersByDepartment>(int departmentId)
    //delete
    int deleteById(int id);
    void clearAll();
}
