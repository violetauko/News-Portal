package models;

import java.util.Objects;

public class News {
    @Override
    public String toString() {
        return "News{" +
                "GeneralNews='" + GeneralNews + '\'' +
                ", departmentId=" + departmentId +
                ", id=" + id +
                '}';
    }

    private String GeneralNews;
    private int departmentId;
    private int id;

    public News(String generalNews, int departmentId) {
        GeneralNews = generalNews;
        this.departmentId = departmentId;
    }

    public String getGeneralNews() {
        return GeneralNews;
    }

    public void setGeneralNews(String generalNews) {
        GeneralNews = generalNews;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return departmentId == news.departmentId && GeneralNews.equals(news.GeneralNews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(GeneralNews, departmentId);
    }
}
