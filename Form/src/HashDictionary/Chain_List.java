package HashDictionary;
import java.lang.String;

class Chain_List implements Cloneable{

    private String element;

    private Chain_List next;

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public Chain_List getNext() {
        return next;
    }

    public void setNext(Chain_List next) {
        this.next = next;
    }

    public Chain_List clone() throws CloneNotSupportedException {
        return (Chain_List)super.clone();
    }
}
