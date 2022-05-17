package interfaces;

import models.Department;
import models.News;

import java.util.List;

public interface NewsDao {
    //create
    int add(News news);
    News addNewsToDepartment(News news , Department department);

    //read
    List<News> getAll();
    List<News> getNewsByDepartment(int departmentId);
    //delete
    int deleteById(int id);
    void clearAll();
}
