package objects;

/**
 * Created by vanthi on 11/1/2016.
 */

public class CardObject {

    private String id;
    //this data was procesed in controller class
    private String data;
    private String key;
    //contructor must full field for this object
    public CardObject(String id, String key, String data) {
        this.id = id;
        this.key = key;
        this.data = data;
    }


    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
