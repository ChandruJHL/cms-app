package com.itss.cms.dto;

public class LibraryResponse {

    private int id;
    private String libraryName;
    private String bookSection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getBookSection() {
        return bookSection;
    }

    public void setBookSection(String bookSection) {
        this.bookSection = bookSection;
    }

    public int getTotalBook() {
        return totalBook;
    }

    public void setTotalBook(int totalBook) {
        this.totalBook = totalBook;
    }

    private int totalBook;
}
