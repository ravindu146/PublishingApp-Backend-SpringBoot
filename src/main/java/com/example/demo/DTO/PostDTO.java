package com.example.demo.DTO;

public class PostDTO {
    
    private int userId;
    private int postId;
    private String topic;
    private String content;

    public PostDTO() {
    }


    public PostDTO(int userId, int postId, String topic, String content) {
        this.userId = userId;
        this.postId = postId;
        this.topic = topic;
        this.content = content;
    }

    public PostDTO(String topic, String content) {
        this.topic = topic;
        this.content = content;
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

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", postId='" + getPostId() + "'" +
            ", topic='" + getTopic() + "'" +
            ", content='" + getContent() + "'" +
            "}";
    }
}
