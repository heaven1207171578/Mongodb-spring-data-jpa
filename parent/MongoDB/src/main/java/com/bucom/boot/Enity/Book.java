package com.bucom.boot.Enity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

//@Document(collection="book")
public class Book {

    public Book() {
        super();
    }

    public Book(long bookid, String bookName, BigDecimal bookprice) {
        super();
        this.bookid = bookid;
        this.bookName = bookName;
        this.bookprice = bookprice;
    }

    @Id
    private long bookid;
    @Field("book_name")
    private String bookName;
    private BigDecimal bookprice;

    public long getBookid() {
        return this.bookid;
    }

    public String getBookName() {
        return this.bookName;
    }

    public BigDecimal getBookprice() {
        return this.bookprice;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookprice(BigDecimal bookprice) {
        this.bookprice = bookprice;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Book)) return false;
        final Book other = (Book) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getBookid() != other.getBookid()) return false;
        final Object this$bookName = this.getBookName();
        final Object other$bookName = other.getBookName();
        if (this$bookName == null ? other$bookName != null : !this$bookName.equals(other$bookName)) return false;
        final Object this$bookprice = this.getBookprice();
        final Object other$bookprice = other.getBookprice();
        if (this$bookprice == null ? other$bookprice != null : !this$bookprice.equals(other$bookprice)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Book;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $bookid = this.getBookid();
        result = result * PRIME + (int) ($bookid >>> 32 ^ $bookid);
        final Object $bookName = this.getBookName();
        result = result * PRIME + ($bookName == null ? 43 : $bookName.hashCode());
        final Object $bookprice = this.getBookprice();
        result = result * PRIME + ($bookprice == null ? 43 : $bookprice.hashCode());
        return result;
    }

    public String toString() {
        return "Book(bookid=" + this.getBookid() + ", bookName=" + this.getBookName() + ", bookprice=" + this.getBookprice() + ")";
    }
}
