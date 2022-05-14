package interfaces;

import models.News;

import java.util.List;

public interface NewsDao {
    //create
    void add(News news);

    //read
    List<News> getAll();
    // List<Restaurant> getAllNewsByDeparment(int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();
}
