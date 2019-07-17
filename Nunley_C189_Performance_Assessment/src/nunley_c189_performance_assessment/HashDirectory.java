/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class HashDirectory {


    private static final int DEFAULT_BUCKETS = 13;

    private HashBucket<DirectoryEntry>[] hashTable;

    private int numberOfBuckets;

    private int numberOfEntries;


    public HashDirectory(){
        numberOfBuckets = DEFAULT_BUCKETS;
        clear();
    }
        
    public HashDirectory(int count){
        numberOfBuckets = count;
        clear();
    }
	
    public void add(String firstName, String lastName, String phone, String email){
	DirectoryEntry entry = new DirectoryEntry(firstName, lastName, phone, email);
	//CN find the bucket index based on the hash code and bucket count
	int index = entry.hashCode() % numberOfBuckets;
	hashTable[index].add(entry); //CN add entry to the directory
	numberOfEntries++;
    }

    public boolean remove(String firstName, String lastName){
	//CN create new entry to get the hash index on the name
	DirectoryEntry entry = new DirectoryEntry(firstName, lastName);
	//CN get the bucket where name sould be found
	HashBucket<DirectoryEntry> bucket = getBucket(entry);
	return bucket.remove(entry);
    }

    public DirectoryEntry lookup(String firstName, String lastName){
        //CN create a new entry to get the hash index on the name
	DirectoryEntry entry = new DirectoryEntry(firstName, lastName);
	HashBucket<DirectoryEntry> bucket = getBucket(entry);
	int position = bucket.getPosition(entry);
	DirectoryEntry foundEntry = bucket.getEntry(position);
	return foundEntry;
	}
	

    private HashBucket<DirectoryEntry> getBucket(DirectoryEntry entry){
	int bucketIndex = entry.hashCode() % numberOfBuckets;
	HashBucket<DirectoryEntry> bucket = hashTable[bucketIndex];
	return bucket;
    }

    //CN this is safe since we setting all values to null
    public void clear(){
	numberOfEntries = 0;
	hashTable = new HashBucket[numberOfBuckets];
	for(int i = 0; i < numberOfBuckets; i++) {
            hashTable[i] = new HashBucket<DirectoryEntry>();
	}		
    }

    public int getCount(){
        return numberOfEntries;
    }

    public boolean isEmpty(){
        if (numberOfEntries == 0)
            return true;
        else
            return false;
    }

    /*public DirectoryEntry[] toArray(){
        if (numberOfEntries == 0) 
            return null;
        DirectoryEntry[] finalList = new DirectoryEntry[numberOfEntries];
        int i = 0;
	for(int b = 0; b < numberOfBuckets; b++) {
            Comparable<DirectoryEntry>[] tempList = hashTable[b].toArray();
            for(int e = 0; e < tempList.length; e++) {
                finalList[i] = (DirectoryEntry)tempList[e];
                i++;
            }
        }
	return finalList;
    }*/
}
