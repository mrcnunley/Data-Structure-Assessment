/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class HashBucket<T extends Comparable<? super T>> {

    private Node firstNode;

    private int totalNodes;

    public HashBucket(){
        firstNode = null;
        totalNodes = 0;
    }
	
        
    private Node getNodeBefore(T entry){	
        Node currentNode = firstNode;
        Node nodeBefore = null;
            
        while ( currentNode !=null && entry.compareTo(currentNode.getData()) > 0 ){
            nodeBefore = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return nodeBefore;
    }
	
    public void add(T entry){
        Node newNode = new Node(entry);
        Node nodeBefore = getNodeBefore(entry);
            
        if (isEmpty() || nodeBefore == null){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        } else{
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
        }
        totalNodes++;
    }
	
    public boolean remove(T entry){
        boolean inBucket = contains(entry);
        Node nodeBefore = getNodeBefore(entry);

        if (nodeBefore == null && inBucket){
            firstNode = firstNode.getNextNode();
            totalNodes--;
            return true;
        } else if (nodeBefore != null && inBucket){
            Node currentNode = nodeBefore.getNextNode();
            nodeBefore.setNextNode(currentNode.getNextNode());
            totalNodes--;
            return true;
        } else 
            return false;
    }
	
    public T getEntry(int position){
        Node currentNode = firstNode;
		
	if(position < 1 || position > totalNodes || currentNode == null)
            return null;

	for (int i = 1; i < position; i++){
            currentNode = currentNode.getNextNode();
	}
	return currentNode.getData();
    }
	
    public T remove(int position){
	T entry = getEntry(position);
	if (entry != null){
            remove(entry);
            return entry;
	} else
            return null;
    }

    public int getPosition(T entry){
	int pos = 1;
	Node currentNode = firstNode;
		
	while (currentNode != null && entry.compareTo(currentNode.getData()) > 0){
            currentNode = currentNode.getNextNode();
            pos++;
	}
		
	int found = 1;

	if (currentNode == null || !entry.equals(currentNode.getData())) found = -1;
	return pos * found;
    }

    public boolean contains(T entry){
	Node currentNode = firstNode;
	while (currentNode != null && entry.compareTo(currentNode.getData()) > 0){
            currentNode = currentNode.getNextNode();
	}
	return currentNode != null && entry.equals(currentNode.getData());
    }
	
    public boolean isEmpty(){
	if (totalNodes == 0)
            return true;
	else
            return false;
    }
	
    public void clear(){
        totalNodes = 0;
        firstNode = null;
    }
	
    public T[] toArray() {	
	T[] result = (T[])new Comparable[totalNodes];
	int index = 0;
	Node currentNode = firstNode;
	while (index < totalNodes && currentNode != null){
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
	}
	return result;
    }

    private class Node{
	private T data;
	private Node next;
		
	private Node(T newData){
            this(newData, null);
	}
                
	private Node(T newData, Node nextNode){
            data = newData;
            next = nextNode;
	}
		
	private T getData(){
            return data;
        }

	private Node getNextNode(){
            return next;
	}

	private void setNextNode(Node nextNode){
            next = nextNode;
	}
    }

}
