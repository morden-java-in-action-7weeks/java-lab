package modern.practice;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    // Getter
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    // Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "OnlineClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + closed +
                '}';
    }
}
