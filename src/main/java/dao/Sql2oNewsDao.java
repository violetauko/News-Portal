package dao;

import interfaces.NewsDao;
import models.News;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oNewsDao implements NewsDao {

    private final Sql2o sql2o;

    public Sql2oNewsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public int add(News news) {
        String sql = "INSERT INTO news (generalnews, departmentid) VALUES(:generalNews, :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(news)
                    .executeUpdate()
                    .getKey();
            return id;
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
        return 0;
    }

    @Override
    public List<News> getAll() {
        try (Connection con = sql2o.open()) {
            String sql = "SELECT * FROM news";
            return con.createQuery(sql)
                    .executeAndFetch(News.class);

        }
        }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM news WHERE id = :id";
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
        String sql = "DELETE FROM news";
        try(Connection con =sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }


    }
}
