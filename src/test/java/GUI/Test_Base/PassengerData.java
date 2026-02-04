package GUI.Test_Base;

import java.util.HashMap;
import java.util.Map;

public class PassengerData {

    private Map<PassengerKey, Object> data = new HashMap<>();

    public enum PassengerKey {
        ADULT_COUNT,
        CHILD_COUNT,
        INF_COUNT,
        INS_COUNT
    }

    // Generic setter (supports String, Integer, etc.)
    public void set(PassengerKey key, Object value) {
        data.put(key, value);
    }

    // Generic getter
    public Object get(PassengerKey key) {
        return data.get(key);
    }

    // Convenience typed getters (optional but recommended)
    public int getInt(PassengerKey key) {
        return (Integer) data.getOrDefault(key, 0);
    }

    public String getString(PassengerKey key) {
        return (String) data.get(key);
    }


}
