package linkedlistarray;

public class LinkedListArray {

       int data;
       int size = 10;
       int pos = 0;
       int array[] = new int[size];
       LinkedListArray()
       {    
       }
   
   public void insertEnd(int d){
       if(pos == 0){
           array[pos++] = d;

           return;
       }
       if(pos>size-1){
           System.out.println("List full");
       }
       else array[pos++] = d;

   }
   
   public void insertBegg(int d){
       if(pos>size-1)
       {
           System.out.println("List is full");
           return;
       }
       int temp[]=new int[size];
       temp[0]=d;
       for(int i=1;i<=pos;i++)
       {
           temp[i]=array[i-1];
       }
       
       pos++;
       for(int i=0;i<pos;i++)
       {
           array[i]=temp[i];
       }
       
      
   }
    public void insertAtAny(int position,int d){
        
        if(position>pos+1 || position <1)
        {
            return;
        }
        if(position == 0){
            insertBegg(d);
            return;
        }
        if(position == pos ){
            insertEnd(d);
            return;
        }
    int[] result = new int[array.length];
    for(int i=0;i<position;i++){
        result[i] = array[i];
        result[position] = d;
    }
    
    for(int i=position+1;i< array.length; i++)
        result[i] = array[i - 1];
    
    array=result;
    pos++;

   }
   public void delBegg()
   {
       for(int i=0;i<pos-1;i++)
       {
           array[i]=array[i+1];
       }
       pos--;
       this.display();
   }
   public void delEnd()
   {
       array[pos]=0;
       pos--;
       
   }
   public void delAtAny(int position)
   {
       for(int i=position-1;i<pos;i++)
       {
           array[i]=array[i+1];
       }
       pos--;
      
   }
       
  public void display(){
      for(int i=0;i<pos;i++){
          System.out.print(array[i]+"->");
      }
      System.out.println("");
  }
    
    public static void main(String[] args) {
        LinkedListArray list = new LinkedListArray();
        list.insertEnd(10);
        list.insertEnd(20);
        list.insertEnd(130);
        list.insertEnd(140);
        
        list.insertAtAny(0,5);
        list.display();
        list.insertBegg(22);
        list.display();
        list.insertEnd(99);
        list.display();
        list.delBegg();
        list.display();
        list.delEnd();
        list.display();
               
    }
    
}