//James Dunlap   Jcd160230

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
      BSTree tree = new BSTree();
      
      tree.buildSampleTree();
      
      tree.printTree();
      
      int mysum = tree.sum();
      
      System.out.println("Sum is: " + mysum);
      
      mysum = tree.sumodd();
      
      System.out.println("Sum of odd values is: " + mysum);

      mysum = tree.sumleaves();
      
      System.out.println("Sum of leaf values is: " + mysum);
    }  
}
