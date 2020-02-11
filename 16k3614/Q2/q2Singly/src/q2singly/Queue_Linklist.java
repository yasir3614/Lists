
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
    
	public void enque(T d){
		insertEnd(d);
	}
    
	public void dequeue(){
		deleteBegg();
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
        Q2Singly myList = new Q2Singly();
		myList.enque(1);
		myList.enque(2);
		myList.dequeue();
        myList.display();
           
    }   
}
