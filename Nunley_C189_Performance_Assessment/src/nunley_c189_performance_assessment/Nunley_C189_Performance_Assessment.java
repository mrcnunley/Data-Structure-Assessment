/*Created by Chris Nunley for WGU performance assessment
 * C189 Data Structures
 */
package nunley_c189_performance_assessment;

public class Nunley_C189_Performance_Assessment {

    public static void main(String[] args) {

        System.out.println();
	System.out.println("    **********  HashBucket Directory Test  **********    ");
        System.out.println();
	hashDirectoryTest();

        System.out.println();
        System.out.println();
	System.out.println("    **********  Binary Tree Directory Test  **********    ");
	System.out.println();
	testTreeDirectory();
    }
	

    private static void hashDirectoryTest() {
	HashDirectory directory = new HashDirectory(); //CN create a new hash table with default 13 buckets
		
	System.out.println("Test Case 1: Insert Bob Smith");
	directory.add("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		
	System.out.println("Test Case 2: Insert Jane Williams");
	directory.add("Jane", "Williams", "555-235-1112", "jw@something.com");
		
	System.out.println("Test Case 3: Insert Mohammed al-Salam");
	directory.add("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		
	System.out.println("Test Case 4: Insert Pat Jones");
	directory.add("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		
	System.out.println("Test Case 5: Insert Billy Kidd");
	directory.add("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		
	System.out.println("Test Case 6: Insert H. Houdini");
	directory.add("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		
	System.out.println("Test Case 7: Insert Jack Jones");
	directory.add("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		
	System.out.println("Test Case 8: Insert Jill Jones");
	directory.add("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		
	System.out.println("Test Case 9: Insert John Doe");
	directory.add("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		
	System.out.println("Test Case 10: Insert Jane Doe");
	directory.add("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		
	System.out.println("Test Case 11: Lookup Pat Jones");
	DirectoryEntry entry = directory.lookup("Pat", "Jones");
        if (entry != null) 
            System.out.println("  " + entry.toString());
        else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 12: Lookup Billy Kidd");
	entry = directory.lookup("Billy", "Kidd");
        if (entry != null) 
            System.out.println("  " + entry.toString());
        else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 13: Delete John Doe");
        if (directory.remove("John", "Doe")) 
            System.out.println("  Success entry deleted");
        else 
            System.out.println("  Failed to delete enry");
		
	System.out.println("Test Case 14: Insert Test Case");
	directory.add("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		
	System.out.println("Test Case 15: Insert Nadezhda Kanachekhovskaya");
	directory.add("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		
	System.out.println("Test Case 16: Insert Jo Wu");
	directory.add("Jo", "Wu", "555-235-1123", "wu@h.com");
		
	System.out.println("Test Case 17: Insert Millard Fillmore");
	directory.add("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.com");
		
	System.out.println("Test Case 18: Insert Bob vanDyke");
	directory.add("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		
	System.out.println("Test Case 19: Insert Upside Down");
	directory.add("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		
	System.out.println("Test Case 20: Lookup Jack Jones");
	entry = directory.lookup("Jack", "Jones");
        if (entry != null) 
            System.out.println("  " + entry.toString());
        else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 21: Lookup Nadezhda Kanachekhovskaya");
	entry = directory.lookup("Nadezhda", "Kanachekhovskaya");
        if (entry != null) 
            System.out.println("  " + entry.toString());
        else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 22: Delete Jill Jones");
        if (directory.remove("Jill", "Jones")) 
            System.out.println("  Success entry deleted");
        else 
            System.out.println("  Failed to delete entry");
		
	System.out.println("Test Case 23: Delete John Doe");
        if (directory.remove("John", "Doe")) 
            System.out.println("  Success entry deleted");
        else 
            System.out.println("  Failed to delete entry");
		
	System.out.println("Test Case 24: Lookup Jill Jones");
	entry = directory.lookup("Jill", "Jones");
        if (entry != null) 
            System.out.println("  " + entry.toString());
        else 
            System.out.println("  No match found");
		
	System.out.println("Test Case 25: Lookup John Doe");
	entry = directory.lookup("John", "Doe");
        if (entry != null) 
            System.out.println("  " + entry.toString());
        else 
            System.out.println("  No match found");
    }
        
    private static void testTreeDirectory() {
	BSTDirectory directory = new BSTDirectory(); //create a new binary search tree directory
		
	System.out.println("Test Case 1: Insert Bob Smith");
	directory.add("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
		
	System.out.println("Test Case 2: Insert Jane Williams");
	directory.add("Jane", "Williams", "555-235-1112", "jw@something.com");
		
	System.out.println("Test Case 3: Insert Mohammed al-Salam");
	directory.add("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
		
	System.out.println("Test Case 4: Insert Pat Jones");
	directory.add("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
		
	System.out.println("Test Case 5: Insert Billy Kidd");
	directory.add("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
		
	System.out.println("Test Case 6: Insert H. Houdini");
	directory.add("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
		
	System.out.println("Test Case 7: Insert Jack Jones");
	directory.add("Jack", "Jones", "555-235-1117", "jjones@hill.com");
		
	System.out.println("Test Case 8: Insert Jill Jones");
	directory.add("Jill", "Jones", "555-235-1118", "jillj@hill.com");
		
	System.out.println("Test Case 9: Insert John Doe");
	directory.add("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
		
	System.out.println("Test Case 10: Insert Jane Doe");
	directory.add("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");
		
	System.out.println("Test Case 11: Lookup Pat Jones");
	DirectoryEntry entry = directory.lookup("Pat", "Jones");
	if (entry != null) System.out.println("  " + entry.toString());
	else System.out.println("  No match found.");
		
	System.out.println("Test Case 12: Lookup Billy Kidd");
	entry = directory.lookup("Billy", "Kidd");
	if (entry != null) 
            System.out.println("  " + entry.toString());
	else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 13: Delete John Doe");
	if (directory.remove("John", "Doe")) 
            System.out.println("  Success entry deleted");
	else 
            System.out.println("  Failed to delete entry");
		
	System.out.println("Test Case 14: Insert Test Case");
	directory.add("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
		
	System.out.println("Test Case 15: Insert Nadezhda Kanachekhovskaya");
	directory.add("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
		
	System.out.println("Test Case 16: Insert Jo Wu");
	directory.add("Jo", "Wu", "555-235-1123", "wu@h.com");
		
	System.out.println("Test Case 17: Insert Millard Fillmore");
	directory.add("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.com");
		
	System.out.println("Test Case 18: Insert Bob vanDyke");
	directory.add("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
		
	System.out.println("Test Case 19: Adding Upside Down");
	directory.add("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");
		
	System.out.println("Test Case 20: Lookup Jack Jones");
	entry = directory.lookup("Jack", "Jones");
	if (entry != null)
            System.out.println("  " + entry.toString());
	else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 21: Lookup Nadezhda Kanachekhovskaya");
	entry = directory.lookup("Nadezhda", "Kanachekhovskaya");
	if (entry != null) 
            System.out.println("  " + entry.toString());
	else 
            System.out.println("  No match found.");
		
	System.out.println("Test Case 22: Delete Jill Jones");
	if (directory.remove("Jill", "Jones")) 
            System.out.println("  Success entry deleted");
	else 
            System.out.println("  Failed to delete entry");
		
	System.out.println("Test Case 23: Delete John Doe");
	if (directory.remove("John", "Doe")) 
            System.out.println("  Success entry deleted");
	else 
            System.out.println("  Failed to delete entry");
		
	System.out.println("Test Case 24: Lookup Jill Jones");
	entry = directory.lookup("Jill", "Jones");
	if (entry != null) 
            System.out.println("  " + entry.toString());
	else 
            System.out.println("  No match found");
		
	System.out.println("Test Case 25: Lookup John Doe");
	entry = directory.lookup("John", "Doe");
	if (entry != null) 
            System.out.println("  " + entry.toString());
	else 
            System.out.println("  No match found");

    }
}
