package com.example.demo.DTO;

import java.time.LocalDate;

import org.springframework.cglib.core.Local;

public class PostDTO {
    
    private int userId;
    private int postId;
    private String topic;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;

    public PostDTO() {
    }


    public PostDTO(int userId, int postId, String topic, String content, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.postId = postId;
        this.topic = topic;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PostDTO(int userId, String topic, String content, LocalDate startDate, LocalDate endDate) {
        this.userId = userId;
        this.topic = topic;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
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


    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", postId='" + getPostId() + "'" +
            ", topic='" + getTopic() + "'" +
            ", content='" + getContent() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            "}";
    }

}
