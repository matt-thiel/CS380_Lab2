package lab2;

class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   /*
   inserts a node into the tree
   */
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//closing while
      
      }//closing main if-else 
   }
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //implement me
	   
	   if (root == null) {
		   return;
	   }
	   
	   // value is accessed here
	   System.out.println(root.value);
	   
	   preOrderTraversal(root.left);
	   preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //implement me
	   if (root == null) {
		   return;
	   }
	   
	   preOrderTraversal(root.left);
	   // value is accessed here
	   System.out.println(root.value);
	   
	   preOrderTraversal(root.right);
	   
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
	    
	   if (root == null) {
		   return;
	   }
	   
	   preOrderTraversal(root.left);
	   preOrderTraversal(root.right);
	   // value is accessed here
	   System.out.println(root.value);
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
      if (root == null) {
		   return false;
	   }
	   
	   boolean found = false;
	   
	   if(root.value == key){  
		   found = true;  
           return found;  
	   }
	   
	   // Search the left side of the tree
	   if(found == false && root.left != null){  
		   found = find(root.left, key);  
	   }  
	   
	   // Search the right side of the tree
	   if(found == false && root.right != null){  
		   found = find(root.right, key);  
	   }     
	   
	   return found;
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
      
	   if (root == null) {
		   return -1;
	   }
	   
	   // create a temp node for walking through the tree
	   Node temp = root;
	   
	   while (temp.left != null) {
		   temp = temp.left;
	   }
	   
	   return temp.value;

   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
     
	   if (root == null) {
		   return -1;
	   }
	   
	   // create a temp node for walking through the tree
	   Node temp = root;
	   
	   while (temp.right != null) {
		   temp = temp.right;
	   }
	   
	   return temp.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   
   
}



public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}