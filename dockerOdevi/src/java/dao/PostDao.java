package dao;

import entity.Post;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class PostDao extends DBConnection {

    private List<Post> list;


    public String create(Post entity) {
        try {
            Statement st = this.conn().createStatement();
            String query = "insert into post (title,context)values('" + entity.getTitle() + "' ,'" + entity.getContext() + "')";
            st.executeUpdate(query);

        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        return "index";
    }

    public List<Post> getList() {
        list = new ArrayList<>();
        try {
            Statement st = this.conn().createStatement();
            String query = "select * from  post;";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Post(rs.getInt("id"), rs.getString("title"), rs.getString("context")));
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());

        }
        return list;
    }

    public void delete(Post entity) {
        try {
            Statement st = this.conn().createStatement();
            String query = "delete from post where id = '" + (entity.getId()) + "'";
            st.executeUpdate(query);
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    public void update(Post entity) {
        try {
            Statement st = this.conn().createStatement();
            String query = "UPDATE post SET title ='" + (entity.getTitle()) +"', context = '" + (entity.getContext()) + "' where id = '"+ (entity.getId()) +"'";
            st.executeUpdate(query);
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

}
