import java.util.*;
public class ex5 {
    public static <K, V> Map<V, K> invertMap(Map<K, V> sourceMap) {
        Map<V, K> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : sourceMap.entrySet()) {
            K oldKey = entry.getKey();
            V oldValue = entry.getValue();
            invertedMap.put(oldValue, oldKey);
        }
        return invertedMap;
    }
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("Россия", "Москва");
        countries.put("Франция", "Париж");
        countries.put("Япония", "Токио");
        System.out.println("Исходная карта (Страна -> Столица):");
        System.out.println(countries);
        Map<String, String> capitals = invertMap(countries);
        System.out.println("Измененная карта (Столица -> Страна):");
        System.out.println(capitals);
    }
}
