package com.steady.d7_collection.MAP.MAKE;


public class hash_HashMap<K,V>{
    private final Entry[] hs = new Entry[100];

    public static void main(String[] args) {
        hash_HashMap<Object,Object> h = new hash_HashMap<>();
        h.put("xx",0);
        h.put(3,"kk");
        
        System.out.println(h.get(3));
        System.out.println(h.get("xx"));
        h.put("a","a");
        h.put(97,97);
        System.out.println(h.get("a"));
    }

    static class Entry<K,V>{
        K k;
        V v;
        int hash;
        Entry<K,V> next;
        public Entry(K k, V v, int hash) {
            this.k = k;
            this.v = v;
            this.hash = hash;
        }
    }


    public void put(K k,V v){
        int hashk = k.hashCode();

        int index = k.hashCode() % hs.length;

        if (hs[index] == null){
            hs[index] = new Entry<>(k,v,hashk);
        }else {
            hs[index].next = new Entry<>(k, v,hashk);
        }

    }

    public Object get(K k){
        int index = k.hashCode()%hs.length;

        for (Entry entry = hs[index];entry != null;entry = entry.next){
            if (entry.hash == k.hashCode() && entry.k.equals(k)){
                return entry.v;
            }
        }
        return null;
    }
}
