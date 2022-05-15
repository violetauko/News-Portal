package interfaces;

import models.News;

import java.util.List;

public interface NewsDao {
    //create
    int add(News news);

    //read
    List<News> getAll();
    // List<Department> getAllNewsByDeparment(int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();
}
