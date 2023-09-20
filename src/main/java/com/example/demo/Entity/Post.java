package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "post_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "topic", length = 255)
    private String topic;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "user_id", length = 255)
    private int userId;


    public Post() {
    }


    public Post(int postId, String topic, String content, int userId) {
        this.postId = postId;
        this.topic = topic;
        this.content = content;
        this.userId = userId;
    }

    public Post( String topic, String content, int userId) {
        this.topic = topic;
        this.content = content;
        this.userId = userId;
    }


    public int getPostId() {
        return this.postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "{" +
            " postId='" + getPostId() + "'" +
            ", topic='" + getTopic() + "'" +
            ", content='" + getContent() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }

}
