package dao;

import data.Post;

import java.util.Scanner;

public class Forum {

   // Community [] allMembers;
    Post[] posts;
    int size;

    public Forum (int capacity) {
        posts = new Post[capacity];
        size = 0;
    }

    public boolean addPost (Post post) {
        if (size < posts.length) {
            posts[size] = post;
            size++;
            return true;
        }
        return false;
    }

    public boolean deletePost (int id) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getId() == id) {
                posts[i] = posts[size-1];
                size--;
                return true;
            }
        }
        return false;
    }

    public void displayPost () {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
            System.out.println();

        }
    }

    public boolean updatePost (String userName, int id, String content) {

        for (int i = 0; i < size; i++) {
            if (posts[i].getId() == id && !posts[i].getContent().equalsIgnoreCase(content)) {
                if (posts[i].getAllMembers().isAdmin(userName)) {
                    System.out.println("Please enter a password:");
                    Scanner scanner = new Scanner (System.in);
                    String input = scanner.nextLine();
                        if (posts[i].getAllMembers().isPasswordCorrect(input)) {
                            posts[i].setContent(content);
                            System.out.println("New content is " + posts[i].getContent());
                            return true;
                        }
                    System.out.println("Incorrect password - access is denied ");
                    return false;
                }
                System.out.println("Access is denied");
                return false;
            }
        }
        return false;
    }

    public Post [] getPostsByAuthor (String name, int countPost) {
        Post [] postslist = new Post[countPost];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (posts[i].getAuthor().getName().equalsIgnoreCase(name) && counter < countPost) {
                postslist[counter] = posts[i];
                counter++;
            }
        }
        return postslist;
    }

    public int getLikesCount (String title) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println(posts[i].getAuthor().getName() + " has the following number of likes: " + posts[i].getLike());
                return posts[i].getLike();
            }
        }
        return -1;
    }
}
