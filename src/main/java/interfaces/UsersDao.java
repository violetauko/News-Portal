package interfaces;

import models.News;
import models.Users;

import java.util.List;

public interface UsersDao {
    //create
    void add (Users users);

    //read
    List<Users> getAll();
  List<Users>getAllUsersByDepartment(int departmentId);
    //delete
    int deleteById(int id);
    void clearAll();

    Users findById(int id);
}
