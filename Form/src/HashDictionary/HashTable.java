package HashDictionary;

import java.util.ArrayList;
import java.util.List;

public abstract class HashTable {

    public int size_table;

    public static List<Key_Value> HashArr = new ArrayList<Key_Value>();
    
    public static List<String> str_array = new ArrayList<String>();
    
    public abstract String Add(String value);
    
    public abstract String Find(String string);
    
    public abstract String Delete(String string);
    
    public abstract String[] ViewTable();

    public long HashCode(String value) {
        long hash = 0;//value.length();
        for (int i = 0; i < value.length(); i++) 
            hash += value.charAt(i) * (long)Math.pow(2, i);
        return hash;
    }
}
