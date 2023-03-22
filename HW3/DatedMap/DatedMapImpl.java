package HW3.DatedMap;

import java.util.*;

public class DatedMapImpl implements DatedMap {
    private Map<String, String> map = new HashMap<>();
    private Map<String, Date> dates = new LinkedHashMap<>();

    @Override
    public void put(String key, String value) {
        map.put(key, value);
        dates.put(key, new Date());
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
        dates.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        return dates.get(key);
    }
}