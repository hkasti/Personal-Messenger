package logic;

import java.util.Date;

public class Message {
    private boolean isFile;
    private String content;
    private Person from;
    private Person to;
    private Date time;

    public Message(boolean isFile, String content, Person from, Person to, Date time) {
        this.isFile = isFile;
        this.content = content;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public boolean isFile() {
        return isFile;
    }

    public String getContent() {
        return content;
    }

    public Person getFrom() {
        return from;
    }

    public Person getTo() {
        return to;
    }

    public Date getTime() {
        return time;
    }
}
