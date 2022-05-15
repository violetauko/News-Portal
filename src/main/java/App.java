import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import dao.Sql2oUsersDao;
import models.Department;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
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

        post("/users/new", "application/json",(req, res) ->{
            Users users = gson.fromJson(req.body(),Users.class) ;
            usersDao.add(users);
            res.status(201);
            return gson.toJson(users);// display
        });

        get("/users","application/json",(req, res) ->{
            return gson.toJson(usersDao.getAll());//send it back to be displayed
        });

            post("/users/:id","application/json",(req, res)-> {
                    int departmentId = Integer.valueOf(req.params("departmentId"));
                    Users users = gson.fromJson(req.body(), Users.class);

                    users.setDepartmentId(departmentId);
                    usersDao.add(users);
                    res.status(201);
                    return gson.toJson(users);
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






        after((req, res) ->{
            res.type("application/json");
        });
        }
}
