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

    public int countOccurrences(String search) {
        int count = 0;
        int fromIndex = -1;
        do {
            fromIndex = data.indexOf(search, fromIndex + 1);
            if (fromIndex != -1) {
                count++;
            }
        } while (fromIndex != -1);
        return count;
    }

    public void replaceAll(String search, String replace) {
        data = data.replace(search, replace);
    }
}
