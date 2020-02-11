
package doubly;

public class Doubly<T> {

    public class node<T>{
        T data;
        node next;
        node prev;
        public node(T d){
            this.next = null;
            this.prev = null;
            this.data = d;
        }
    }
    int size=0;
    node head  =null;
    node tail = null;
    node sec = null;
    //insertAtbeg
    public void insertBeg(T d){
        node newnode = new node(d);
        if(size==0){
            head = newnode;
            tail = newnode;
        }
        else{
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
        size++;
//        display();
    }
    //insertLast
    public void insertLast(T d){
        node newnode = new node(d);
        if(size==0){
            insertBeg(d);
            return;
        }
        else{
            sec = tail;
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
        size++;
//        display();
    }
    //insertAnywhere
    public void insertAt(int pos,T d){
        if(pos>size+1||pos<1){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            insertBeg(d);
            return;
        }
        if(pos==size){
            insertLast(d);
            return;
        }
        else{
            node newnode = new node(d);
            int count = 1;
            node current = head;
            while(count<pos-1){
                current = current.next;
                count++;
            }
            node temp = current.next;
            newnode.next = temp;
            temp.prev = newnode;
            newnode.prev = current;
            current.next = newnode;
        }
        size++;
//        display();
    }
    //deleteBeg
    public void deleteBeg(){
        node temp = head.next;
        if(size==0){
            System.out.println("List empty");
            return;
        }
        else{
            head.next = null;
            head = temp;
        }
        size--;
//        display();
    }
    //deleteLast
    public void deleteLast(){
        if(size==0){
            System.out.println("List empty");
            return;
        }
        else{
            node prvs = null;
            node current = head;
            while(current.next!=null){
                prvs=current;
                current = current.next;
            }
            prvs.next = null;
            tail = prvs;
        }
        size--;
    }
    //delete anywhere
    public void deleteAt(int pos){
        if(pos>size||pos<1){
            System.out.println("Invalid position");
            return;
        }
        if(pos==1){
            deleteBeg();
            return;
        }
        if(pos==size){
            deleteLast();
            return;
        }
        else{
            int count = 1;
            node current = head;
            while(count<pos-1){
                current = current.next;
                count++;
            }
            node temp = current.next;
            current.next = temp.next;
            temp.next=null;
        }
        size--;
//        display();
    }
    public  <T extends Comparable<T>> void  InsertionSort(){
        if(size==0){
            System.out.println("List empty");
            return;
        }
        System.out.println("Sorted List: ");
       //insertion sort on contents
        T temp;
        node current = head;
        node i = null;
        while(current!=null){
            temp = (T) current.data;
            while(i!=null&&temp.compareTo((T)i.data) < 0){
                int c = 0;
                current.data = i.data;
                i.data = temp;
                i = i.prev;
                c++;
                if(c>0){
                    current = i.next;
                }
            }
            if(current.next==null){
                display();
                return;
            }
            current = current.next;
            i=current.prev;
        }
        display();
    }
    //display
    public void display(){
        if(size==0){
            System.out.println("List empty");
            return;
        }
        else{
            node current = head;
            while(current!=null){
                System.out.print(current.data+"->");
                current = current.next;
            }
        }
        System.out.println();
        
    }
    public static void main(String[] args) {
        Doubly list = new Doubly();
        list.insertBeg(1);
        list.insertLast(5);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(4);
        System.out.println("Unsorted list:");
        list.display();
        list.InsertionSort();
    }
    
}
