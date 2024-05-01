package entity;


import java.io.Serializable;



public class Post implements Serializable {

    private int id;
    private String title;
    private String context;

    public Post() {
    }

    public Post(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public Post(int id, String title, String context) {
        this.id = id;
        this.title = title;
        this.context = context;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", title=" + title + ", context=" + context + '}';
    }

}
