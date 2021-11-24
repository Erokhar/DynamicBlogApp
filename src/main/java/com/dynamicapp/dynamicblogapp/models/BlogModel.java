package com.dynamicapp.dynamicblogapp.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Blogs")
@Entity
@Component
public class BlogModel {
    @Id
    @Column(name = "blogid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogid;

    @Column(name = "blogauthor")
    private int blogauthor;

    @Column(name = "blogtitle")
    private String blogtitle;

    @Column(name = "blogcontent")
    private String blogcontent;

    @Column(name="blogpublishdate")
    private Date blogpublishdate;

    public int getBlogid() {
        return blogid;
    }

    public void setBlogid(int blogid) {
        this.blogid = blogid;
    }

    public int getBlogauthor() {
        return blogauthor;
    }

    public void setBlogauthor(int blogauthor) {
        this.blogauthor = blogauthor;
    }

    public String getBlogtitle() {
        return blogtitle;
    }

    public void setBlogtitle(String blogtitle) {
        this.blogtitle = blogtitle;
    }

    public String getBlogcontent() {
        return blogcontent;
    }

    public void setBlogcontent(String blogcontent) {
        this.blogcontent = blogcontent;
    }

    public Date getBlogpublishdate() {
        return blogpublishdate;
    }

    public void setBlogpublishdate(Date blogpublishdate) {
        this.blogpublishdate = blogpublishdate;
    }

    @Override
    public String toString() {
        return "BlogModel{" +
                "blogid=" + blogid +
                ", blogauthor=" + blogauthor +
                ", blogtitle='" + blogtitle + '\'' +
                ", blogcontent='" + blogcontent + '\'' +
                ", blogpublishdate=" + blogpublishdate +
                '}';
    }
}

