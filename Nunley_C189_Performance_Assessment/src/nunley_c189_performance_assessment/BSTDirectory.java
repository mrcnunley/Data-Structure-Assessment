/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class BSTDirectory{
    BinarySearchTree<DirectoryEntry> tree;
	
    public BSTDirectory() {
	tree = new BinarySearchTree<DirectoryEntry>();
    }
	
    //CN add new directory entry
    public void add(String firstName, String lastName, String email, String phone) {
	DirectoryEntry entry = new DirectoryEntry(firstName, lastName, phone, email);
	tree.add(entry);
    }
    //CN remove entry
    public boolean remove(String firstName, String lastName) {
	DirectoryEntry entry = new DirectoryEntry(firstName, lastName);
	return tree.remove(entry);
    }
    //CN lookup entry
    public DirectoryEntry lookup(String firstName, String lastName) {
	DirectoryEntry result = null;
	result = tree.getEntry(new DirectoryEntry(firstName, lastName));
	return result;
    }

    /*public void clear() {
	tree.clear();
    }

    public int getCount() {
	return tree.getNumberOfNodes();
    }

    public boolean isEmpty() {
	return tree.isEmpty();
    }*/
}
