package interfaces;

import models.Users;

import java.util.List;

public interface UsersDao {
    //create
    void add (Users users);

    //read
    List<Users> getAll();
    Users findById(int id);
    // List<Department> getAllDepartmentsForAUser(int restaurantId);

    //delete
    void deleteById(int id);
    void clearAll();
}
