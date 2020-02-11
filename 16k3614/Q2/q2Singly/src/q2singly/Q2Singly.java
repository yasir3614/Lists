
package q2singly;

public class Q2Singly <T>{

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
        Q2Singly myList = new Q2Singly();
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
