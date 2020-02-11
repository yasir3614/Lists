
package singlylinklistusinginterface;
import java.util.LinkedList;

public class SinglyLinkListUsingInterface {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(12);
        list.add(13);
        list.add("Yasir");
        System.out.println(list);
        list.addFirst(12);
        System.out.println(list);
        list.addLast(99);
        System.out.println(list);
        list.add(5, 55);
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        System.out.println(list);
                
    }
    
}
