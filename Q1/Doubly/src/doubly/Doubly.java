
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
    node beforeTail = null; // node before the tail
    
    //Function To Insert At Beggining of List
    public void insertBegg(T d){
        node nodeToAdd = new node(d);
        if(size==0){
            head = nodeToAdd;
            tail = nodeToAdd;
        }else{
            nodeToAdd.next = head;
            head.prev = nodeToAdd;
            head = nodeToAdd;
        }
        size++;

    }
    
    //Function To Insert At The End of the list ( last )

    public void insertEnd(T d){
        node nodeToAdd = new node(d);
        if(size==0){
            insertBegg(d);
            return;
        }else{
            beforeTail = tail;
            tail.next = nodeToAdd;
            nodeToAdd.prev = tail;
            tail = nodeToAdd;
        }
        size++;
    }
    
    //Function To Insert In the list, Any where.
    public void insertAtAnyPos(int pos,T d){
        if(pos>size+1||pos<1){
            System.out.println("Incorrect position");
            return;
        }
        if(pos==1){
            insertBegg(d);
            return;
        }
        if(pos==size){
            insertEnd(d);
            return;
        }else{
            node nodeToAdd = new node(d);
            int i = 1;
            node current = head;
            while(i<pos-1){
                current = current.next;
                i++;
            }
            node temp = current.next;
            nodeToAdd.next = temp;
            temp.prev = nodeToAdd;
            nodeToAdd.prev = current;
            current.next = nodeToAdd;
        }
        size++;
   }
    
    //Function to delete node from beginning
    public void deleteBegg(){
        node temp = head.next;
        if(size==0){
            System.out.println("List is currently empty");
            return;
        }else{
            head.next = null;
            head = temp;
        }
        size--;

    }
    
    //Function to delete End Node
    public void deleteEnd(){
        if(size==0){
            System.out.println("List is currently empty");
            return;
        }else{
            node prevs = null;
            node current = head;
            while(current.next!=null){
                prevs=current;
                current = current.next;
            }
            prevs.next = null;
            tail = prevs;
        }
        size--;
    }
    
    //Function to delete anywhere in the list.
    public void deleteAtPosition(int pos){
        if(pos>size||pos<1){
            System.out.println("Incorrect position");
            return;
        }
        if(pos==1){
            deleteBegg();
            return;
        }
        if(pos==size){
            deleteEnd();
            return;
        }else{
            int i = 1;
            node current = head;
            while(i<pos-1){
                current = current.next;
                i++;
            }
            node temp = current.next;
            current.next = temp.next;
            temp.next=null;
        }
        size--;
    }
    
    //Function To Display Nodes in the list.
    public void display(){
        if(size==0){
            System.out.println("List is currently empty");
            return;
        }else{
            node current = head;
            while(current!=null){
                System.out.print(current.data+"->");
                current = current.next;
            }
        }
        System.out.println();
        
    }
    
    //Function To Insertly Sort The List
    public  <T extends Comparable<T>> void  sort(){
        if(size==0){
            System.out.println("List is currently empty");
            return;
        }
        System.out.println("Insertly Sorted List: ");
       
        T temp;
        
        node current = head;
        node i = null;
        
        while(current!=null){
            temp = (T) current.data;
            while(i!=null && temp.compareTo((T)i.data) < 0){
                int j = 0;
                current.data = i.data;
                i.data = temp;
                i = i.prev;
                j++;
                if(j>0){
                    current = i.next;
                }
            }
            if(current.next==null){
                return;
            }
            current = current.next;
            i=current.prev;
        }
       
    }
    public static void main(String[] args) {
        Doubly mylist = new Doubly();
        //We can not sort a list with different data types so I chose integer data instead.
        mylist.insertEnd(1);
        mylist.insertEnd(25);
        mylist.insertEnd(22);
        mylist.insertEnd(12);
        mylist.insertEnd(565);
        mylist.insertEnd(2);
        mylist.insertEnd(33);
        mylist.insertEnd(124);
        mylist.sort();
        mylist.display();
   
    }
    
}
