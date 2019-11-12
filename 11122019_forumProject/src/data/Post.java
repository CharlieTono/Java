package data;

import dao.Community;

public class Post {

    private Community allMembers;
    private User author;
    private int id;
    private String title;
    private String content;
    private int like = 0;

    public Post(Community allMembers, User author, int id, String title, String content) {
        this.allMembers = allMembers;
        this.author = author;
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getLike() {
        return like;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Community getAllMembers() {
        return allMembers;
    }

    public void setAllMembers(Community allMembers) {
        this.allMembers = allMembers;
    }

    @Override
    public String toString() {
        return "Post ID: " + id + ", by author: " + author + "\n" +
                title.toUpperCase() + ": " + content + "\n" +
                "likes: " + like;
    }

    public int addlike () {
        return like++;
    }

    public int disLike () {
        return like--;
    }

}
