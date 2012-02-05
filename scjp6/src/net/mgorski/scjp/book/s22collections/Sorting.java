package net.mgorski.scjp.book.s22collections;

import java.util.ArrayList;
import java.util.Collections;

public class Sorting {
    
    
    public static void main(String[] args) {
    
        ArrayList<Song> al = new ArrayList<Song>();
        al.add(new Song("www","zzz"));
        al.add(new Song("bbb","fff"));
        al.add(new Song("sss","mmm"));
        al.add(new Song("ddd","zzz"));
        
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);
    }
    
    

}

class Song implements Comparable<Song>{
    
    private String title;
    private String author;

    public Song(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "{" + author + ",>>"+ title + "<<}";
    }

    @Override
    public int compareTo(Song o) {
        return this.getTitle().compareTo(o.getTitle());
    }

}