package Model;

public class listItems {
    private String title;
    private String descr;

    public listItems(String title, String descr) {
        this.title = title;
        this.descr = descr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
