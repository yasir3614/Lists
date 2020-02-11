
package singly;

public class Singly <T>{

    public class node{
        T data;
        node next;
        public node(T d){
            this.next = null;
            this.data = d;
        }
    }
    
    node head = null;
    node tail = null;
    int size=0;
    
    //Function To Insert At Beggining of List
    public void insertBegg(T d){
        node nodeToAdd = new node(d);
        if(size==0){
            head = nodeToAdd;
            tail = nodeToAdd;
        }else{
            nodeToAdd.next = head;
            head = nodeToAdd;
        }
        size++;

    }
    
    //Function To Insert At The End of the list ( last )
    public void insertEnd(T d){
        node nodeToAdd = new node(d);
        if(size==0){
            head = nodeToAdd;
            tail = nodeToAdd;
        }else{
            tail.next = nodeToAdd;
            tail = nodeToAdd;
        }
        size++;

    }
    
    //Function To Insert In the list, Any where.
    public void insertAtAnyPos(int pos,T d){
        
        if(pos>size+1||pos<1){
            System.out.println("Incorrect position");
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
            int i=1;
            node current = head;
            while(i<size-1){
                current = current.next;
                i++;
            }
            current.next = null;
            tail = current;
        }
        size--;
    }
 
    //Function To Display Nodes in the list.
    public void display(){
        if(size==0){
            System.out.println("List is currently empty");
            return;
        }else{
            node i = head;
            while(i!=null){
                System.out.print(i.data+"->");
                i = i.next;
            }
        }
        System.out.println();
        
    }
    
    public static void main(String[] args) {
        Singly myList = new Singly();
        myList.insertAtAnyPos(1, "Yasir");
        myList.insertAtAnyPos(2, 'K');
        myList.insertAtAnyPos(3, "163614");
        myList.insertAtAnyPos(4, "Section A");
        myList.insertAtAnyPos(5, false);
        myList.display();
        myList.deleteBegg();
        myList.display();
        myList.insertAtAnyPos(3, 100);
        myList.insertAtAnyPos(2, "Pakistan");
        myList.display();
        
    }
    
}
