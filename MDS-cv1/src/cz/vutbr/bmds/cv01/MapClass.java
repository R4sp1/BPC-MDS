package cz.vutbr.bmds.cv01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapClass {

    private HashMap<Integer, String> map = new HashMap<>() {

        @Override
        public int size() {
            return map.size();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public String get(Object key) {
            return map.get(key);
        }

        @Override
        public String put(Integer key, String value) {
            return map.put(key, value);
        }

        @Override
        public String remove(Object key) {
            return map.remove(key);
        }

        @Override
        public void putAll(Map<? extends Integer, ? extends String> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<String> values() {
            return null;
        }

        @Override
        public Set<Entry<Integer, String>> entrySet() {
            return null;
        }
    };

    public MapClass(int key, String value) {
        map.put(key, value );
    }

    @Override
    public String toString() {
        return "MapClass{" +
                "map=" + map +
                '}';
    }

    public void print() {
        System.out.print("Map(");
        map.forEach((k, v) -> System.out.println(("<" + k + ">" + "->" + "<" + v + ">")));
        System.out.println();
    }

}
