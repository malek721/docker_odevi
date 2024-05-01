package controller;

import dao.PostDao;
import entity.Post;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

import java.util.List;

@Named(value = "postController")
@SessionScoped

public class PostController implements Serializable {

    private PostDao dao;
    private Post entity;
    private List<Post> list;

    public PostController() {
    }

    public PostDao getDao() {
        if (dao == null) {
            dao = new PostDao();
        }
        return dao;
    }

    public void setDao(PostDao dao) {
        this.dao = dao;
    }

    public Post getEntity() {
        if (entity == null) {
            entity = new Post();
        }
        return entity;
    }

    public void setEntity(Post entity) {
        this.entity = entity;
    }

    public List<Post> getList() {
        list = this.getDao().getList();
        return list;
    }

    public void setList(List<Post> list) {
        this.list = list;
    }

    public void create() {
        this.getDao().create(entity);
        this.entity = new Post();
    }

    public void update() {
        this.getDao().update(this.entity);
        this.entity = new Post();
    }

    public void delete(Post entity) {
        this.getDao().delete(entity);
    }
}
