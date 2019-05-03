package file;

public class Content {
    private String data;

    public Content(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean contains(String search) {
        return data.toUpperCase().contains(search.toUpperCase());
    }
}
