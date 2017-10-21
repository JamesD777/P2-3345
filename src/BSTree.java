

/**
 *
 * @author James Dunlap
 */
public class BSTree {

    private Node root;
    private Node root1;
   
    public BSTree(){
        root = null;
    }
    
    public BSTree(Node t){
        t = root;
    }
    public void buildSampleTree()
    {

       Node ll = new Node(0, null, null);
       Node rl = new Node(3, null, null);
       Node rr = new Node(5, null, null);

       Node l = new Node(1, ll, null);
       Node r = new Node(4, rl, rr);

       root = new Node(2, l, r);
    }
    public void buildSampleTreeModified()
    {

       Node ll = new Node(0, null, null);
       Node rl = new Node(3, null, null);
       Node rr = new Node(1, null, null);

       Node l = new Node(56, ll, null);
       Node r = new Node(3, rl, rr);

       root1 = new Node(2, l, r);
    }

    public void printTree()
    {
       printTree(root);
    }

    private void printTree(Node t)
    {
       if (t != null)
       {
          printTree(t.left);
          System.out.println(t.data);
          printTree(t.right);
       }   
    }
    
    public int sum()
    {
       return sum(root);
    }

    private int sum(Node t)
    {
       if (t == null)
          return 0;
       else
          return t.data + sum(t.left) + sum(t.right);
    }
    
    public int sumodd()
    {
       return sumodd(root);
    }

    private int sumodd(Node t)
    {
       if (t == null)
          return 0;
       else
          if (t.data%2 == 0)
             return sumodd(t.left) + sumodd(t.right);
          else
             return t.data + sumodd(t.left) + sumodd(t.right);
    }


    public int sumleaves()
    {
       return sumleaves(root);
    }

    private int sumleaves(Node t)
    {
       if (t == null)
          return 0;
       else
          if (t.left == null && t.right == null)
             return t.data;
          else
             return sumleaves(t.left) + sumleaves(t.right);         

    }
    //my code
    public int count(){
        return count(root);
    }
    private int count(Node t){
       if (t == null)
          return 0;
       return 1+count(t.right)+count(t.left);
    }
   
    public boolean isFull(){
        return isFull(root);
    } 
    private boolean isFull(Node t){
        if(t == null)
            return true;
        if(t.right == null && t.left == null)
            return true;
        if(t.right == null && t.right == null){
            boolean right = isFull(t.right);
            boolean left = isFull(t.left);
            return (left && right);
        }
        return false; //if there is only 1 child null, it isnt complete
    }
    
    public boolean compareStructure(){
        return compareStructure(root, root1);
    }
    private boolean compareStructure(Node t, Node t1){
        if (t == null && t1 == null)
           return true;
        if (t == null || t1 == null)
            return false;
        if (t.data != t1.data)
            return false;
        if(compareStructure(t.right, t1.right) && compareStructure(t.left, t1.left))
            return true;
        if(compareStructure(t.right, t1.left) && compareStructure(t.left, t1.right));
            return true;
    }
    
    public boolean equals() {
       return equals(root, root1);
    }
    private boolean equals(Node t, Node t1) {
        if (t == null && t1 == null)
            return true;
        if (t != null && t1 != null)
            if(t.data == t1.data)
                if(equals(t.right, t1.right) && equals(t.left, t1.left))
                    return true;
        return false;
    }
    
    public Node copy()
    {
       return copy(root);
    }
    private Node copy(Node t) {
        Node left = null;
        Node right = null;
        if (t.left != null) {
            left = copy(t.left);
        }
        if (t.right != null) {
            right = copy(t.right);
        }
        return new Node(t.data, left, right);
    }
    
    public Node mirror() {
        return mirror(root);
    }
    private Node mirror(Node t) {
        if (t == null)
            return t;
        t.right = mirror(t.left);
        t.left = mirror(t.right);
        return t;
    }

    public boolean isMirror() {
        return isMirror(root, root1);
    }
    private boolean isMirror(Node t, Node t1){

        if (t == null && t1 == null)
            return true;
        if (t == null || t1 == null)
            return false;
        if(t.data == t1.data)
            if(isMirror(t.right, t1.left) && isMirror(t.left, t1.right))
                return true;
        return false;
    }
    private Node find(int data, Node t){
        if(t != null){
            if(t.data == data)
               return t;
            else {
                Node foundNode = find(data, t.left);
                if(foundNode == null)
                    foundNode = find(data, t.right);
                return foundNode;
            }
        }  
        else
            return null;
    }
    public Node rotateLeft(int data){
        Node t = find(data, root); //find the node with the given data
        if(t == null) //if the data wasnt found, return null
            return t;
        Node tReplace = t.right;    //rotate the nodes around the given node
        Node leftofReplace = tReplace.left;
        tReplace.left = t;
        t.right = leftofReplace;
        return tReplace;
    }
    public Node rotateRight(int data){
        Node t = find(data, root); //find the node with the given data
        if(t == null) //if the data wasnt found, return null
            return t;
        Node tReplace = t.left;    //rotate the nodes around the given node
        Node rightofReplace = tReplace.right;
        tReplace.left = t;
        t.right = rightofReplace;
        return tReplace;
    }
    public int maxDepth(Node t) //find the max depth of the tree
    {
        if (t == null)
            return 0;
        else{
            int rightDepth = maxDepth(t.right);
            int leftDepth = maxDepth(t.left);
            if (rightDepth > leftDepth)
                return (rightDepth + 1);
             else
                return (leftDepth + 1);
        }
    }
    public void printLevels(){
        for(int i = 0; i< maxDepth(root); i++){
            printLevels(root, i);
            System.out.println();
        }
    }
    private void printLevels(Node t, int i){
        if(t == null)
            System.out.println("No nodes in this tree");
        else if(i == 0)
            System.out.print(t.data);
        else{
            printLevels(t.left, i--);
            printLevels(t.right, i--);
        }
    }
}
