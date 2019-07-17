/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class DirectoryEntry implements Comparable<DirectoryEntry>{

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String emailAddress;
	

    public DirectoryEntry(String first, String last, String phone, String email){
	firstName = first;
	lastName = last;
	phoneNumber = phone;
	emailAddress = email;
    }

    public DirectoryEntry(String first, String last){
	this(first, last, null, null);
    }

	
    //CN Setter and Getters
    public String getFirstName(){
	return firstName;
    }
    
    public void setFirstName(String first){
	firstName = first;
    }
	
    public String getLastName(){
	return lastName;
    }
	
    public void setLastName(String last){
	lastName = last;
    }

    public String getName(){
	return firstName + " " + lastName;
    }

    public String getEmailAddress(){
           return emailAddress;
    }
    
    public void setEmailAddress(String email){
           emailAddress = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
	
    public void setPhoneNumber(String phone){
        phoneNumber = phone;
    }

    //CN Override the parent compareTo()
    @Override
    public int compareTo(DirectoryEntry entry){
        return this.getName().toUpperCase().compareTo(entry.getName().toUpperCase());
    }
        
    //CN Override the parent equals()
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!DirectoryEntry.class.isAssignableFrom(obj.getClass())) return false;
        DirectoryEntry entry = (DirectoryEntry)obj;
        return this.getName().toUpperCase().equals(entry.getName().toUpperCase());
    }
	
    //CN Override the parent hashCode()
    @Override
    public int hashCode() {
        int hash = 0;
        int g = 3;
        String name = getName().toUpperCase();
        int n = name.length();
		
        for (int i = 0; i < n; i++){
            hash = g * name.charAt(i);
        }
        return hash;
    }
	
    public String toString() {
        String result = getName() + "; " + phoneNumber + "; " + emailAddress;
        return result;
    }
}
