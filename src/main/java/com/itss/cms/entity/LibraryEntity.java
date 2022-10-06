package com.itss.cms.entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="Library")
public class LibraryEntity {
    @Id
    @Column(name="Library_id")
    int LibraryId;
    @Column(name="Library_name")
    String LibraryName;
    @Column(name="Book_section")
    String BookSection;
    @Column(name="Total_book")
    int TotalBook;

    public int getLibraryId() {
        return LibraryId;
    }

    public void setLibraryId(int libraryId) {
        LibraryId = libraryId;
    }

    public String getLibraryName() {
        return LibraryName;
    }

    public void setLibraryName(String libraryName) {
        LibraryName = libraryName;
    }

    public String getBookSection() {
        return BookSection;
    }

    public void setBookSection(String bookSection) {
        BookSection = bookSection;
    }

    public int getTotalBook() {
        return TotalBook;
    }

    public void setTotalBook(int totalBook) {
        TotalBook = totalBook;
    }
}
