import java.util.*;

public class LeafSum {
	
	public int leafSum(TreeNode t) {
	    int sum = 0;
	    if (t == null) {
	        return sum;
	    }
	    if(t.left==null && t.right==null){
	    	return sum + t.info;
	    }
	    else{
	    	return leafSum(t.left) + leafSum(t.right);
	    }
	    //initialize queue
	    Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
	    myQueue.offer(t);    
	
	    while(!myQueue.isEmpty()) {
	        int size = myQueue.size();
	
	        for (int i = 0; i < size; i++) {
	            TreeNode temp = myQueue.poll(); //poll retrieves and removes the head of this queue
	            if (temp.left == null && temp.right == null) {
	                sum += temp.info;
	            }
	            if (temp.left != null) {
	                myQueue.add(temp.left);
	            }
	            if (temp.right != null) {
	                myQueue.add(temp.right);
	            }
	        }
	    }
	    return sum;
	}	
	public class TreeNode {
	      int info;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x){
	          info = x;
	      }
	      TreeNode(int x, TreeNode lNode, TreeNode rNode){
	          info = x;
	   	  left = lNode;
	          right = rNode;
	      }
	  }
}
