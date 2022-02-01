package loay.sholy.loaytasksmanager.data;


public class MyTask {
    private  String key;
    private String title;
    private String subject;
    private String owner;
    private int  important;
    private String large;



    public MyTask(){

    }
    public String getKey() {
        return key;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getOwner() {
        return owner;
    }

    public int getImportant() {
        return important;
    }

    public String getLarge() {
        return large;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}