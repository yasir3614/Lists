
package q2doubly;

public class Q2Doubly<T> {

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
    
    public void checkDuplicate(T d){
        int count = 0;
        node i = head;
        
        while(i!=null){
            if(i.data == d){
                count ++;
            }
            i=i.next;
        }
        System.out.println("Total Occurrences of " + '"'+d+'"' +" are: "+count);
        System.out.println("");
    }
    
    public static void main(String[] args) {
        Q2Doubly myList = new Q2Doubly();
        myList.insertEnd(1);
        myList.insertEnd(2);
        myList.insertEnd(1);
        myList.insertEnd(4);
        myList.insertEnd(1);
        myList.insertEnd(1);
        myList.insertEnd(7);
        myList.display();
        myList.checkDuplicate(1); 
    }
    
}
