package HashDictionary;

import java.util.Collections;

public class ClosedHashing extends HashTable {

    public ClosedHashing(int size_table) {
        this.size_table = size_table;
    }

    @Override
    public String Add(String value) {
        long firstHash = HashCode(value);
        long hash = firstHash;
        if (value.length() <= size_table) {
            int i = 0;
            while (true) {
                long finalHash = hash;
                if (HashArr.stream().filter(item -> item.key == finalHash).count() <= 0) {
                    HashArr.add(new Key_Value(hash, value));
                    break;
                }
                else {
                    hash = (firstHash + i) % size_table + 1; i++;
                    if (i > size_table) break;
                }
            }
            if (i > size_table)
                return "The hash table is full!";
            else
                return "The item '" + value + "' is added to the hash table.";
        }
        else
            return "Item length is too long!";
    }
    
    @Override
    public String Find(String string) {
        long mas = 0;
        try {
            long firstHash = HashCode(string);
            long hash = firstHash;
            int i = 0;
            while (true) {
                long finalHash = hash;
                Key_Value key_v = HashArr.stream().filter(item -> item.key == finalHash).findFirst().get();
	            if (key_v.value_string.equals(string)) {
		            mas = hash;
		            break;
	            }
	            else {
                    hash = (firstHash + i) % size_table + 1; i++;
                    if (i > size_table) break;
	            }
            }
            if (i > size_table)
                return "Can`t find item!";
            else
                return "The item has a hash " + mas;
        }
        catch (Exception e) {
            return "Can`t find item!";
        }
    }
    
    @Override
    public String Delete(String string) {
        try {
            long firstHash = HashCode(string);
            long hash = firstHash;
            int i = 0;
            while (true) {
                long finalHash = hash;
                Key_Value key_v = HashArr.stream().filter(item -> item.key == finalHash).findFirst().get();
	            if (key_v.value_string.equals(string)) {
	            	HashArr.remove(key_v);
		            break;
	            }
	            else {
                    hash = (firstHash + i) % size_table + 1; i++;
                    if (i > size_table) break;
	            }
            }
            if (i > size_table)
                return "Can`t find item for deleted!";
            else
                return "Item '" + string + "' deleted.";
        }
        catch (Exception e) {
            return "Can`t delete item!";
        }
    }
    
    @Override
    public String[] ViewTable() {
    	str_array.clear();
    	Collections.sort(HashArr);
    	str_array.add("Key  |    Value");
    	for (int i = 0; i < HashArr.size(); i++) {
    		str_array.add(HashArr.get(i).key + "    |    " + HashArr.get(i).value_string);
    	}
    	return str_array.toArray(new String[str_array.size()]);
    }
}
