/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;
	
    public BinarySearchTree() {
 	root = null;
    }

    public BinarySearchTree(T data) {
	this(data, null, null);
    }

    public BinarySearchTree(T data, BinarySearchTree<T> leftTree, BinarySearchTree<T> rightTree) {
	root = new BinaryNode<T>(data);
	//CN if the left tree is not null, set left child as root
	if (leftTree != null && !leftTree.isEmpty())
            root.setLeftChild(leftTree.root); 

	//CN if the right tree has it's own root node, set right child as root
	if (rightTree != null && !rightTree.isEmpty()) {
            if (rightTree != leftTree)
		root.setRightChild(rightTree.root);
            else
		//CN else, copy the right tree at the root node and set as the right child node
		root.setRightChild(rightTree.root.copy());
	}
    }

    public T getRootData() {
	T rootData = root.getData();
	return rootData;
    }
    
    public void setRootData(T newData) {
	root.setData(newData);
    }
    
    public BinaryNode<T> getRootNode() {
        return root;
    }
    
    public void setRootNode(BinaryNode<T> newNode) {
	root = newNode;
    }

    public T add(T newData) {
	T result = null;
	//CN if the tree is empty, set newData as root
	if(isEmpty()) setRootNode(new BinaryNode<T>(newData));
	else result = privateAdd(root, newData);
	return result;
    }

    private T privateAdd(BinaryNode<T> rootNode, T newData) {
	T result = null;
	//CN if data matches root, update data
	if (rootNode.getData().equals(newData)) {
            result = rootNode.getData();
            rootNode.setData(result);
	}
	//CN if the root is greater than the data, traverse the left tree
	else if (rootNode.getData().compareTo(newData) > 0 ) {
	//CN if root has a left child, search node
	if (rootNode.hasLeftChild())
            result = privateAdd(rootNode.getLeftChild(), newData);
	else //CN else add data to new node as left child
            rootNode.setLeftChild(new BinaryNode<T>(newData));	
		}
	//CN if the root is less than data given, traverse the right tree
	else if (rootNode.getData().compareTo(newData) < 0 ) {
	//CN if root has a right child, search node
	if (rootNode.hasRightChild())
            result = privateAdd(rootNode.getRightChild(), newData);
	else //CN else add data to new node as right child
            rootNode.setRightChild(new BinaryNode<T>(newData));	
	}
	return result;
    }

    public boolean remove(T data) {
	if(getEntry(data) == null)
            return false;
	privateRemove(root, data);
	return true;
    }

    private BinaryNode<T> privateRemove(BinaryNode<T> rootNode, T givenData) {
	BinaryNode<T> parentNode = null;
	if (rootNode == null) return null;		
	 
	if (rootNode.getData().equals(givenData))//CN if the data is in the root
            rootNode = removeRootNode(rootNode);
	//CN if data in root is greater traverse left tree and set parent
	else if (rootNode.getData().compareTo(givenData) > 0) {
            parentNode = privateRemove(rootNode.getLeftChild(), givenData);
            rootNode.setLeftChild(parentNode);
		}
	//CN if data in root is less than root traverse right tree and set parent
	else if (rootNode.getData().compareTo(givenData) < 0 ) {
            parentNode = privateRemove(rootNode.getRightChild(), givenData);
            rootNode.setRightChild(parentNode);
	}
	return rootNode;
    }

    private BinaryNode<T> removeRootNode(BinaryNode<T> rootNode) {
	//CN if root node has two child nodes
	if (rootNode.hasLeftChild() && rootNode.hasRightChild()) {
            BinaryNode<T> leftChildNode = rootNode.getLeftChild();
            //CN find the largest right child node in the left tree
            BinaryNode<T> largestChildNode = findLargestNode(leftChildNode);
            //CN set the root node to the largest data found
            rootNode.setData(largestChildNode.getData());
            rootNode.setLeftChild(removeLargestNode(leftChildNode));
	}
	//CN if the root node has only a left child node
	else if (rootNode.hasLeftChild())
            rootNode = rootNode.getLeftChild();
	//CN if the root node has a right child node only
	else if (rootNode.hasRightChild())
            rootNode = rootNode.getRightChild();
	//CN remove root node if it is a leaf
	else rootNode = null;
		
	return rootNode;
    }

    private BinaryNode<T> findLargestNode(BinaryNode<T> rootNode) {
	//CN if the root node has a right node
	if(rootNode.hasRightChild())
            //CN traverse right nodes looking for largest node
            rootNode = findLargestNode(rootNode.getRightChild());
	return rootNode;
    }

    private BinaryNode<T> removeLargestNode(BinaryNode<T> rootNode) {
	//CN if the root node has a right node
	if(rootNode.hasRightChild()) {
            //CN traverse right nodes looking for largest node
            BinaryNode<T> newRoot = removeLargestNode(rootNode.getRightChild());
            rootNode.setRightChild(newRoot); //CN set right child as new root
	}
	else
            rootNode = rootNode.getLeftChild(); //CN return left node if there is no right.
	return rootNode;
    }
	
	
	
    public T getEntry(T data) {
	return privateGetEntry(root, data);
    }

    private T privateGetEntry(BinaryNode<T> rootNode, T givenData) {
	T result = null;
	//CN if the data matches get the data in the root node
	if (rootNode.getData().equals(givenData)) {
            result = rootNode.getData();
        }
	//CN if the data in the root is greater, traverse the left tree
	else if (rootNode.getData().compareTo(givenData) > 0 ) {
            //CN if root has a left child, search
            if (rootNode.hasLeftChild())
				result = privateGetEntry(rootNode.getLeftChild(), givenData);
	}
	//CN if the data is less than, traverse the right tree
	else if (rootNode.getData().compareTo(givenData) < 0 ) {
            //CN if root has a right child, search
            if (rootNode.hasRightChild())
		result = privateGetEntry(rootNode.getRightChild(), givenData);
	}
	return result;
    }

    public int getHeight() {
	return root.getHeight();
    }
    
    public int getNumberOfNodes() {
	return root.getNumberOfNodes();
    }
    
    public boolean isEmpty() {
	return (root == null);
    }
    
    public void clear() {
	root = null;
    }
}
