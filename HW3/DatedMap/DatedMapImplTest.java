package HW3.DatedMap;

public class DatedMapImplTest {
    public static void main(String[] args) {
        DatedMap datedMap = new DatedMapImpl();
        datedMap.put("key1", "value1");
        datedMap.put("key2", "value2");
        datedMap.put("key3", "value3");
        datedMap.put("key4", "value4");

        System.out.println(datedMap.get("key1"));
        System.out.println(datedMap.containsKey("key2"));
        datedMap.remove("key3");
        System.out.println(datedMap.keySet());
        System.out.println(datedMap.getKeyLastInsertionDate("key4"));
    }
}
