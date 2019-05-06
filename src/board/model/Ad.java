package board.model;

import java.time.LocalDateTime;

public class Ad {
    private LocalDateTime dateTime;
    private String text;
    private String author;
    private String title;

    public Ad(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
