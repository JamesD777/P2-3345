//James Dunlap   Jcd160230

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
      BSTree tree = new BSTree();
      
      tree.buildSampleTree();
      tree.buildSampleTreeModified();
      
      tree.printTree();
      
      int mysum = tree.sum();
      
      System.out.println("Sum is: " + mysum);
      
      mysum = tree.sumodd();
      
      System.out.println("Sum of odd values is: " + mysum);

      mysum = tree.sumleaves();
      
      System.out.println("Sum of leaf values is: " + mysum);
      
      int count = tree.count();
      
      System.out.println("Count: " + count);
      
      System.out.println("The tree is full? : " + tree.isFull());
      
      System.out.println("The sample tree 1 and two are the same structure? : " + tree.compareStructure());
      System.out.println("The sample tree 1 and two are equal? : " + tree.equals());
      System.out.println("Copy: ");
      BSTree copiedTree = new BSTree(tree.copy());
      copiedTree.printTree();
      System.out.println("Mirror: ");
      BSTree mirroredTree = new BSTree(tree.mirror());
      mirroredTree.printTree();
      System.out.println("Is the new initial second tree we built a mirror?: " + tree.isMirror());
      System.out.println("Rotated Right: ");
      tree.rotateRight(2);
      tree.printTree();
      System.out.println("Rotated Left: ");
      tree.rotateLeft(56);
      tree.printTree();
      System.out.println("printed levels: ");
      tree.printLevels();
    }  
}
