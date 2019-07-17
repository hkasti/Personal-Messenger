package logic;

import java.util.Date;

public class Message {
    private boolean isFile;
    private String content;
    private String from;
    private String to;
    private Date time;

    public Message(boolean isFile, String content, String from, String to, Date time) {
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

    public String getFrom() {
        System.out.println(from);
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getTime() {
        return time;
    }
}
