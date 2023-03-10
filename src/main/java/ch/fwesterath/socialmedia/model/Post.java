package ch.fwesterath.socialmedia.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
@NamedQuery(name = "Post.findAll", query = "FROM Post")
public class Post {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "caption")
    private String caption;

    @Column(name = "topic")
    private String topic;

//    Relation to User class table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", caption='" + caption + '\'' +
                ", topic='" + topic + '\'' +
                ", user=" + user +
                '}';
    }
}
