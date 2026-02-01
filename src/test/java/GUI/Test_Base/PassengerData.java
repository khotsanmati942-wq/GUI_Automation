package GUI.Test_Base;

import java.util.HashMap;
import java.util.Map;

public class PassengerData {

    private Map<String, Object> data = new HashMap<>();

    public void AdultCountset(String key, Object value) {
        data.put(key, value);
    }
    public Object AdultCountget(String key) {
        return data.get(key);
    }

    public void ChildCountset(String key, Object value) {
        data.put(key, value);
    }
    public Object ChildCountget(String key) {
        return data.get(key);
    }

    public void INFCountset(String key, Object value) {
        data.put(key, value);
    }
    public Object INFtCountget(String key) {
        return data.get(key);
    }

    public void INSCountset(String key, Object value) {
        data.put(key, value);
    }
    public Object INStCountget(String key) {
        return data.get(key);
    }
}
