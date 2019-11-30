/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class Search {
    private String bookId;
    private String bookTitle;
    private String publisherName;
    private String authorName;
    private String note;

    public Search(String bookId, String bookTitle, String publisherName, String authorName, String note) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.publisherName = publisherName;
        this.authorName = authorName;
        this.note = note;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getNote() {
        return note;
    }
    
    public Object [] toDataRow(){
        return new Object[]{bookId,bookTitle,publisherName,authorName,note};
    }
    
    public void print(){
        System.out.println(bookId + ":" + bookTitle + ":" + publisherName + ": "+ note);
    }
}
