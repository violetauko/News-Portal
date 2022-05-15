package dao;

import interfaces.DepartmentDao;
import models.Department;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {


    private final Sql2o sql2o;
    public Sql2oDepartmentDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public int add(Department department) {
        String sql = "INSERT INTO departments (name, description, totalemployees) VALUES(:name, :description, :totalEmployees)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .executeUpdate()
                    .getKey();
            return id;
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
        return 0;
    }

    @Override
    public List<Department> getAll() {
        try(Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM departments WHERE id = :id";
        try(Connection con =sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

        }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM departments";
        try(Connection con =sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }



        }
}
