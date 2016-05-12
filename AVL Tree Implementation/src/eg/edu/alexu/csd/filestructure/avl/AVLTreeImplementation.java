package eg.edu.alexu.csd.filestructure.avl;

import java.util.HashMap;

public class AVLTreeImplementation <T extends Comparable<T>> implements IAVLTree<T>{

	private AvlElements <T> root;
	private HashMap<T, Integer> avlValues = new HashMap<T, Integer>();
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getRootHeight() {
		
		return root.getHeight();
	}

	public HashMap<T, Integer> getAvlValues() {
		return avlValues;
	}

	private boolean searchNode;
	
	private int balance(AvlElements <T> balanceNode){
		
		if(balanceNode == null) {
			return 0;
		}
		
		int leftHeight = 0, rightHeight = 0;
		
		if(balanceNode.leftChild != null) leftHeight = balanceNode.leftChild.getHeight();
		if(balanceNode.rightChild != null) rightHeight = balanceNode.rightChild.getHeight();
		
		balanceNode.setHeight(Math.max(leftHeight, rightHeight) + 1);
		
		return leftHeight - rightHeight;
	}
	
	private AvlElements <T> leftRotate(AvlElements <T> tempNode1){
		
		AvlElements <T> tempNode2 = tempNode1.getRightChild();
		AvlElements <T> subTree = tempNode2.getLeftChild();
		
		tempNode2.setLeftChild(tempNode1);
		tempNode1.setRightChild(subTree);
		
		int leftHeight = 0, rightHeight = 0;
		
		if(tempNode1.leftChild != null) leftHeight = tempNode1.leftChild.getHeight();
		if(tempNode1.rightChild != null) rightHeight = tempNode1.rightChild.getHeight();
		
		tempNode1.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		leftHeight = 0;
		rightHeight = 0;
		
		if(tempNode2.leftChild != null) leftHeight = tempNode2.leftChild.getHeight();
		if(tempNode2.rightChild != null) rightHeight = tempNode2.rightChild.getHeight();
		
		tempNode2.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		return tempNode2;
	}
	
	private AvlElements <T> rightRotate(AvlElements <T> tempNode1){
		
		AvlElements <T> tempNode2 = tempNode1.getLeftChild();
		AvlElements <T> subTree = tempNode2.getRightChild();
		
		tempNode2.setRightChild(tempNode1);
		tempNode1.setLeftChild(subTree);
		
		int leftHeight = 0, rightHeight = 0;
		
		if(tempNode1.leftChild != null) leftHeight = tempNode1.leftChild.getHeight();
		if(tempNode1.rightChild != null) rightHeight = tempNode1.rightChild.getHeight();
		
		tempNode1.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		leftHeight = 0;
		rightHeight = 0;
		
		if(tempNode2.leftChild != null) leftHeight = tempNode2.leftChild.getHeight();
		if(tempNode2.rightChild != null) rightHeight = tempNode2.rightChild.getHeight();
		
		tempNode2.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		return tempNode2;
	}
	
	private AvlElements <T> compareBalance(AvlElements <T> balanceNode, T key, int balanceFactor){
		
		if(balanceFactor > 1 && key.compareTo(balanceNode.leftChild.getValue()) < 0 ) return rightRotate(balanceNode);
		else if (balanceFactor < -1 && key.compareTo(balanceNode.rightChild.getValue()) > 0 ) return leftRotate(balanceNode);
		else if (balanceFactor > 1 && key.compareTo(balanceNode.leftChild.getValue()) > 0 ){
			
			balanceNode.setLeftChild(leftRotate(balanceNode.getLeftChild()));
			return rightRotate(balanceNode);
			
		} else if (balanceFactor < -1 && key.compareTo(balanceNode.rightChild.getValue()) < 0 ){
			
			balanceNode.setRightChild(rightRotate(balanceNode.getRightChild()));
			return leftRotate(balanceNode);
		}
		
		return balanceNode;
	}
	
	private int getNodeBalance(AvlElements <T> balanceNode){
		
		int leftHeight = 0, rightHeight = 0;
		
		if(balanceNode.leftChild != null) leftHeight = balanceNode.leftChild.getHeight();
		if(balanceNode.rightChild != null) rightHeight = balanceNode.rightChild.getHeight();
		
		return leftHeight - rightHeight;
		
	}
	
	private AvlElements <T> compareBalanceDelete(AvlElements <T> balanceNode, T key, int balanceFactor){
		
		int leftHeight = 0, rightHeight = 0;
		
		if(balanceNode.leftChild != null) leftHeight = balanceNode.leftChild.getHeight();
		if(balanceNode.rightChild != null) rightHeight = balanceNode.rightChild.getHeight();
		
		balanceNode.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		AvlElements <T> leftNode = balanceNode.getLeftChild();
		AvlElements <T> rightNode = balanceNode.getRightChild();
		
		int leftBalance = 0, rightBalance = 0;
		
		if(leftNode != null) leftBalance = getNodeBalance(balanceNode.getLeftChild());
		if(rightNode != null) rightBalance = getNodeBalance(balanceNode.getRightChild());
		
		if(balanceFactor > 1 && leftBalance >= 0 ) return rightRotate(balanceNode);
		else if (balanceFactor < -1 && rightBalance <= 0 ) return leftRotate(balanceNode);
		else if (balanceFactor > 1 && leftBalance < 0 ){
			
			balanceNode.setLeftChild(leftRotate(balanceNode.getLeftChild()));
			return rightRotate(balanceNode);
			
		} else if (balanceFactor < -1 && rightBalance > 0 ){
			
			balanceNode.setRightChild(rightRotate(balanceNode.getRightChild()));
			return leftRotate(balanceNode);
		}
		
		return balanceNode;
	}
	
	private AvlElements <T> insertNode(AvlElements <T> comparingNode, T key){
		
		if(comparingNode == null){
			
			AvlElements <T> newNode = new AvlElements<T>();
			newNode.setValue(key);
			return newNode;
		}
		
		if(key.compareTo(comparingNode.getValue()) < 0) 
			comparingNode.setLeftChild(insertNode( (AvlElements<T>) comparingNode.getLeftChild(), key));
		
		else comparingNode.setRightChild(insertNode( (AvlElements<T>) comparingNode.getRightChild(), key)); 
	
		int leftHeight = 0, rightHeight = 0;
		
		if(comparingNode.leftChild != null) leftHeight = comparingNode.leftChild.getHeight();
		if(comparingNode.rightChild != null) rightHeight = comparingNode.rightChild.getHeight();
		
		comparingNode.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		int balanceFactor = balance(comparingNode);
		
		return compareBalance(comparingNode, key, balanceFactor);
	}
	
	@Override
	public void insert(T key) {
	
		root = insertNode(root , key);
		size++;
		
		if(avlValues.containsKey(key) == true){
			
			avlValues.put(key, avlValues.get(key) + 1);
			
		} else avlValues.put(key, 1);
	}
	
	private AvlElements <T> getSuccessor(AvlElements <T> node){
		
		AvlElements <T> currentNode = node;
		
		while(currentNode.getLeftChild() != null) currentNode = currentNode.getLeftChild();
		
		return currentNode;
	}
	
	private AvlElements <T> deleteNode(AvlElements <T> rootNode , T key){
		
		if(rootNode == null) return null;
		
		if(key.compareTo(rootNode.getValue()) < 0) rootNode.setLeftChild(deleteNode(rootNode.leftChild, key));
		else if (key.compareTo(rootNode.getValue()) > 0) rootNode.setRightChild(deleteNode(rootNode.rightChild, key));
		else {
			
			if(rootNode.getLeftChild() == null || rootNode.getRightChild() == null){
				
				AvlElements <T> tempNode = null;
				
				if(tempNode == rootNode.getLeftChild()) tempNode = rootNode.getRightChild();
				else tempNode = rootNode.getLeftChild();
				
				if(tempNode == null){
					
					tempNode = rootNode;
					rootNode = null;
					
				} else rootNode = tempNode;
				
			} else {
				
				AvlElements <T> tempNode = getSuccessor(rootNode.getRightChild());
				rootNode.setValue(tempNode.getValue());
				rootNode.setRightChild(deleteNode(rootNode.getRightChild(), tempNode.getValue()));
			}
		}
		
		if(rootNode == null) return null;
		
		int leftHeight = 0, rightHeight = 0;
		
		if(rootNode.leftChild != null) leftHeight = rootNode.leftChild.getHeight();
		if(rootNode.rightChild != null) rightHeight = rootNode.rightChild.getHeight();
		
		rootNode.setHeight( Math.max(leftHeight , rightHeight ) + 1 );
		
		int balanceFactor = balance(rootNode);
		return compareBalanceDelete(rootNode, key, balanceFactor);
	}

	@Override
	public boolean delete(T key) {
		
		boolean checkExistence = false;
		
		if(avlValues.containsKey(key) == true){
			
			checkExistence = true;
			int valueRepition = avlValues.get(key);
			if(valueRepition == 1) avlValues.remove(key);
			else avlValues.put(key, avlValues.get(key) - 1);
			deleteNode(root, key);
			size--;
		}
		
		if(size == 0) root = null;
		return checkExistence;
	}

	private void searchAVL(AvlElements <T> rootNode, T key){
		
		if(rootNode == null) return;
			
		if(key.compareTo(rootNode.getValue()) < 0) searchAVL(rootNode.getLeftChild(), key);
		else if(key.compareTo(rootNode.getValue()) > 0) searchAVL(rootNode.getRightChild(), key);
		else {
			
			searchNode = true;
			return;
		}
	}
	
	@Override
	public boolean search(T key) {
		
		searchNode = false;
		searchAVL(root, key);
		
		return searchNode;
	}

	@Override
	public int height() {
		
		if(root == null) return 0;
		return root.getHeight();
	}

	@Override
	public INode<T> getTree() {
		
		return root;
	}

	public void setRoot(AvlElements <T> root) {
		this.root = root;
	}

	public class AvlElements <T extends Comparable<T> > implements INode<T> {

		private int elementindex;
		private T elementValue;
		private int height = 1;
		private AvlElements <T> rightChild;
		private AvlElements <T> leftChild;
		
		@Override
		public AvlElements <T> getLeftChild() {
		
			return leftChild;
		}

		@Override
		public AvlElements <T> getRightChild() {
			
			return rightChild;
		}

		public void setRightChild(AvlElements <T> rightChild) {
			this.rightChild = rightChild;
		}

		public void setLeftChild(AvlElements<T> leftChild) {
			this.leftChild = leftChild;
		}

		@Override
		public T getValue() {
			
			return elementValue;
		}

		@Override
		public void setValue(T value) {
			
			this.elementValue = value;
		}

		public int getelementindex() {
			return elementindex;
		}

		public void setelementindex(int elementindex) {
			this.elementindex = elementindex;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

	}

}
