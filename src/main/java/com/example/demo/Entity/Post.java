package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "imageName")
    private String imageName;

    public Post() {
    }


    public Post(int postId, int userId, String topic, String content, LocalDate startDate, LocalDate endDate, String imageName) {
        this.postId = postId;
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageName = imageName;
    }

    public Post( int userId, String topic, String content, LocalDate startDate, LocalDate endDate, String imageName) {
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.imageName = imageName;
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

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getImageName() {
        return this.imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    @Override
    public String toString() {
        return "{" +
            " postId='" + getPostId() + "'" +
            ", topic='" + getTopic() + "'" +
            ", content='" + getContent() + "'" +
            ", userId='" + getUserId() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", imageName='" + getImageName() + "'" +
            "}";
    }

    
}
