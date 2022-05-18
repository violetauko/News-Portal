package dao;
import interfaces.UsersDao;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUsersDao implements UsersDao {

    private final Sql2o sql2o;
    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o; }


    @Override
    public void add(Users users) {
            String sql = "INSERT INTO users (name, position, role, departmentid) VALUES(:name, :position, :role, :departmentId)";
            try (Connection con = sql2o.open()) {
                int id = (int) con.createQuery(sql, true)
                        .bind(users)
                        .executeUpdate()
                        .getKey();
               users.setId(id);
            }catch (Sql2oException ex){
                System.out.println(ex);
            }
    }

    @Override
    public List<Users> getAll() {
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public List<Users> getAllUsersByDepartment(int departmentId) {
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM users WHERE departmentid = :departmentId")
                    .addParameter("departmentId", departmentId)
                    .executeAndFetch(Users.class);
        }
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        try(Connection con =sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

        return id;
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM users";
        try(Connection con =sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public Users findById(int id){
        String sql = "SELECT * FROM users WHERE  id = :id";
        try(Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        }catch (Sql2oException error){
            throw  error;
        }
    }
}
