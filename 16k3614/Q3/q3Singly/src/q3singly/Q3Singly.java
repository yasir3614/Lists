
package q3singly;

public class Q3Singly <T>{

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
    
    //Function to reverse linked list
     public void reverse(){
         if(head==null){
             return;
         }
         node current=head;
         node prevNode=null;
         node nextNode=null;
         
         while(current!=null){
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
            head=prevNode;
         }
        
     }
    
    public static void main(String[] args) {
        Q3Singly myList = new Q3Singly();
        myList.insertEnd(1);
        myList.insertEnd("c");
        myList.insertEnd("yasir");
        myList.insertEnd(true);
        myList.insertEnd("3");
        myList.display();
        myList.reverse();
        myList.display();
        
    }
    
}
