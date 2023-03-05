package com.steady.d7_collection.MAP.MAKE;

import java.util.ArrayList;

public class Arr_HashMap<K,V>{

    public static void main(String[] args) {
        Arr_HashMap<java.io.Serializable, String> obj = new Arr_HashMap<>();
        obj.put("xx","vv");
        obj.put(2,"4");
        
        System.out.println(obj.get(2));
        System.out.println(obj.get("xx"));

    }
    
    private final ArrayList<Entry<K,V>> MAP = new ArrayList<>();

    public void put(K k,V v){
        MAP.add(new Entry<>(k, v));
    }

    public V get(K k){
        for (Entry<K, V> kvEntry : MAP) {
            if (kvEntry.k.equals(k)){
                return kvEntry.v;
            }
        }
        return null;
    }
    
    /**
     *使用泛型,创建map的节点
     */
    static class Entry<K,V>{
        K k;
        V v;
        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
}