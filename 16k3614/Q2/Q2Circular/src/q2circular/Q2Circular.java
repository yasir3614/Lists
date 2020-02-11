
package q2circular;

public class Q2Circular<T> {

    public class node<T>{
        T data;
        node next;
        public node(T d){
            this.next = null;
            this.data = d;
        }
    }
    int size=0;
    node head  =null;
    node tail = null;
    
        
    //Function To Insert At Beggining of List
    public void insertBegg(T d){
        node nodeToAdd = new node(d);
        if(size==0){
            head = nodeToAdd;
            tail = nodeToAdd;
            tail.next = head;
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
            insertBegg(d);
            return;
        }else{
            tail.next = nodeToAdd;
            tail = nodeToAdd;
            tail.next = head;
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
            nodeToAdd.next = current.next;
            current.next = nodeToAdd;
        }
        size++;
    }
    
    //Function to delete node from beginning
    public void deleteBegg(){
        node temp = head.next;
        
        if(size==0){
            System.out.println("List empty");
            return;
        }else{
            head.next = null;
            head = temp;
            tail.next = head;
        }
        size--;
    }
    
    //Function to delete End Node
    public void deleteEnd(){
        if(size==0){
            System.out.println("List empty");
            return;
        }else{
            node prvs = null;
            node current = head;
            while(current.next!=head){
                prvs=current;
                current = current.next;
            }
            prvs.next = null;
            tail = prvs;
            tail.next = head;
        }
        size--;
    }
    
    //Function to delete anywhere in the list.
    public void deleteAtPos(int pos){
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

    }
    
    //Function To Display Nodes in the list.
    public void display(){
        if(size==0){
            System.out.println("List empty");
            return;
        }
        else{
            node i = head;
            while(i.next!=head){
                System.out.print(i.data+"->");
                i = i.next;
            }
            
            System.out.print(i.data+"->");
            System.out.print(i.next.data+"->");
        }
        System.out.println();
        
    }
    
     public void checkDuplicate(T d){
        int count = 0;
        node i = head;
        
        while(i!=tail){
            if(i.data == d){
                count ++;
            }
            i=i.next;
        }
        System.out.println("Total Occurrences of " + '"'+d+'"' +" are: "+count);
        System.out.println("");
    }
     
    public static void main(String[] args) {
        Q2Circular myList = new Q2Circular();
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
