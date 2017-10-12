package HashDictionary;

import java.util.Comparator;

class Key_Value implements Comparable {

    public long key = 0;

    public String value_string = "";

    public Chain_List value_list = new Chain_List();

    public Key_Value(long key, String value_string) {
        this.key = key;
        this.value_string = value_string;
    }

    public Key_Value(long key, Chain_List value_list) {
        this.key = key;
        this.value_list = value_list;
    }
    
	@Override
	public int compareTo(Object obj) {
		return this.key < ((Key_Value)obj).key ? -1 : this.key > ((Key_Value)obj).key ? 1 : 0;
	}
}
