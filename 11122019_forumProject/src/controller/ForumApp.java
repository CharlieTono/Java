package controller;

import dao.Community;
import dao.Forum;
import data.Admin;
import data.Post;
import data.User;

public class ForumApp {
    public static void main(String[] args) {

        User person01 = new User("Oscar", 30);
        User person02 = new User ("Oliver", 35);
        User person03 = new User ("Nicole", 32);
        User person04 = new Admin("Mark", 27);

        Community people = new Community (100);
        people.addMember(person01);
        people.addMember(person02);
        people.addMember(person03);
        people.addMember(person04);

        people.displayAllMembers();

        Post message01 = new Post(people, person01,1234, "Job", "CV content");
        Post message02 = new Post (people, person02, 5678, "Health", "Medical centers");
        Post message03 = new Post(people, person03,9012, "Food", "A list of bars");
        Post message04 = new Post (people, person03, 9013, "Food", "The best restaurants");
        Post message05 = new Post (people, person03, 9014, "Food", "Main dish");

        Forum talks = new Forum(20);
        talks.addPost(message01);
        talks.addPost(message02);
        talks.addPost(message03);

        talks.displayPost();
        talks.addPost(message04);
        talks.addPost(message05);
        talks.deletePost(9013);

        message01.addlike();
        message01.addlike();
        message02.addlike();
        message02.addlike();
        message02.disLike();

        Post [] authorPosts = talks.getPostsByAuthor("Nicole", 4);
        display(authorPosts);
        System.out.println("*******");
        talks.updatePost("Mark",9014, "Dinner menu");

    }

    public static void display (Object [] objects) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                System.out.println(objects[i]);
            }
        }
    }
}
