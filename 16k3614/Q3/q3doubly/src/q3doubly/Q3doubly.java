
package q3doubly;

public class Q3doubly<T> {

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
    
    //function to display the list in reverse ( NOT TRANSFORM IN REVERSE)
    public void displayReverse(){
        if(size==0){
            System.out.println("List is currently empty");
            return;
        }else{
            node current = tail;
            while(current!=null){
                System.out.print(current.data+"->");
                current = current.prev;
            }
        }
        System.out.println();
        
    }
    
    public void reverse(){
         node reversedPart = null;
         node current = head;
         node current2 = tail;
         node reversedPart2 =null;
         while (current != null) {
            node next = current.next;
            current.next = reversedPart;
            reversedPart = current;
            current = next;
            
            node next2 = current2.prev;
            current2.prev = reversedPart2;
            reversedPart2 = current2;
            current2 = next2;
         }
            head = reversedPart;
            tail=  reversedPart2;
     }
    
    public static void main(String[] args) {
        Q3doubly mylist = new Q3doubly();
        mylist.insertEnd(1);
        mylist.insertEnd('x');
        mylist.insertEnd(1.24);
        mylist.insertEnd("yasir");
        mylist.insertEnd(true);
        System.out.println("Orignal:");
        mylist.display();
        System.out.println("Reversed:");
        mylist.reverse();
        mylist.display();
        
        System.out.println("From Tail To Head:");
        mylist.displayReverse();
        
    }
    
}
