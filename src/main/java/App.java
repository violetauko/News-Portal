import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import exceptions.ApiException;
import models.Department;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oUsersDao usersDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oNewsDao newsDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:~/newsApi.db;INIT=RUNSCRIPT from 'classpath:db/tables.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        departmentDao = new Sql2oDepartmentDao(sql2o);
        usersDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        post("/departments/new", "application/json",(req, res) ->{
            Department department = gson.fromJson(req.body(),Department.class) ;
            departmentDao.add(department);
            res.status(201);
            return gson.toJson(department);// display
        });

        get("/departments","application/json",(req, res) ->{
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });

        get("/department/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = departmentDao.findById(departmentId);

            if(departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(departmentToFind);

        });

        post("/users/new", "application/json",(req, res) ->{
            Users users = gson.fromJson(req.body(),Users.class) ;
            usersDao.add(users);
            res.status(201);
            return gson.toJson(users);// display
        });

        get("/users","application/json",(req, res) ->{
            return gson.toJson(usersDao.getAll());//send it back to be displayed
        });

        get("/users/:id", "application/json", (req, res) -> {
            int usersId = Integer.parseInt(req.params("id"));
            Users usersToFind = usersDao.findById(usersId);

            if(usersToFind == null){
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(usersToFind);

        });

        get("/users/:id/delete", "application/json", (req, res) -> {
            int usersId = Integer.parseInt(req.params("id"));
            return gson.toJson(usersDao.deleteById(usersId));

        });
            post("/news/new", "application/json",(req, res) ->{
              News news = gson.fromJson(req.body(),News.class) ;
              newsDao.add(news);
              res.status(201);
              return gson.toJson(news);

            });

        get("/news","application/json",(req, res) ->{
            return gson.toJson(newsDao.getAll());//send it back to be displayed
        });

        get("/news/:id", "application/json", (req, res) -> {
            int newsId = Integer.parseInt(req.params("id"));
            News newsToFind = newsDao.findById(newsId);

            if(newsToFind == null){
                throw new ApiException(404, String.format("No news with the id: \"%s\" exists", req.params("id")));
            }

            return gson.toJson(newsToFind);
        });

        exception(ApiException.class, (exc, req, res) -> {
            ApiException err = (ApiException) exc;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(err.getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((req, res) ->{
            res.type("application/json");
        });
        }
}
