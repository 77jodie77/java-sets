import java.util.HashSet;
import java.util.Iterator;

/**
 * Provides an example of using the Java collection classes to implement a 'Set'. In this case making use of a 'HashSet' to store a set of 'Person' objects.
 */
public class Tester
{
    // declare a number of fields to contain Person objects
    private Person p1;
    private Person p2;
    private Person p3;
    private Person p4;
    private Person p5;
    private Person p6;
    private Person p7;   

    /**
     * Default constructor. Initialise fields.
     */
    public Tester() 
    {
        // create instances of various Person objects.
        p1 = new Person("Jane");
        p2 = new Person("Andrew");
        p3 = new Person("Max");
        p4 = new Person("John");
        p5 = new Person("Fred");
        p6 = new Person("Naomi");
        p7 = new Person("Peter");   
    }

    /**
     * A main() method.
     */
    public static void main(String[] args) 
    {
        // create instance of Tester object
        Tester testerObj = new Tester();
        
        // call method to perform Set-related tasks.
        testerObj.doSetOperations();
    }
    
    /**
     * Perform various example operations with a (Hash)Set.
     */
    public void doSetOperations()
    {
        // create three separate Sets containing a different selection of Person objects in them
        HashSet<Person> ac = createSet1();
        HashSet<Person> it = createSet2();
        HashSet<Person> sci = createSet3();
        
        // display the contents of each set
        System.out.println("\n\nUsing HashSet to demonstrate some set operations");
        System.out.print("Set ac: ");
        printSet(ac);
        System.out.print("Set it: ");
        printSet(it);
        System.out.print("Set sci: ");
        printSet(sci);
        
        // use the retainAll method to implement an intersection as below:
        
        // create a temporary set to store the result of the intersection
        HashSet<Person> temp = new HashSet<Person>();
        
        // add / copy the entire contents of one set to the temporary set
        temp.addAll(ac);
        
        // apply the retainAll method to the contents of the temporary set, intersecting it
        // with the contents of another set
        temp.retainAll(it);
        
        // display the contents of the temporary set - it should now contain the result
        // of the intersection
        System.out.println("INTERSECTION: ac and it");
        printSet(temp);
           
        // use the addAll method to implement a union
        // clear the contents of the temporary set
        temp.clear();
        
        // add the contents of two sets to it (their contents will be unioned)
        temp.addAll(ac);
        temp.addAll(it);
        
        // display the content of the Union
        System.out.println("UNION");
        printSet(temp);
           
        // use the containsAll method to determine if a set is a subset of another
        // clear the temporary set
        temp.clear();
        
        // add contents of one set to it
        temp.addAll(sci);   
        
        // if the tempoary set contains the contents of another given set
        if (temp.containsAll(ac)) 
        {
            // the given set is a subset of the contents of the temporary set
            System.out.println("AC IS A SUBSET OF SCI.");
        }
        else
        {
            // not a subset
            System.out.println("AC IS NOT A SUBSET OF SCI.");
        }   
        
        // try with another set
        temp.clear();
        temp.addAll(sci);
        if (temp.containsAll(it)) 
        {
            System.out.println("IT IS SUBSET OF SCI");
        }
        else
        {
            System.out.println("IT IS NOT A SUBSET OF SCI.");
        }   
    }
    
    /**
     * Create and return a new (Hash)Set which contains a selection of Person objects
     * 
     * @return A new HashSet object with Person objects as its content
     */
    public HashSet<Person> createSet1() 
    {       
        // create an instance of a HashSet object which is capable of containing Person objects
        HashSet<Person> hs = new HashSet<Person>();
        
        // add a selection of Person objects to the set (these are references to the Person objects 
        // which are contained as fields in this class)
        hs.add(p1);
        hs.add(p2);
        hs.add(p3);
        hs.add(p4);
        
        // return a reference to the newly created set
        return hs;
        
    }
        
    /**
     * Create and return a new (Hash)Set which contains a different selection of Person objects
     * 
     * @return A new HashSet object with Person objects as its content
     */
    public HashSet<Person> createSet2() 
    {      
        // create an instance of a HashSet object which is capable of containing Person objects
        HashSet<Person> hs = new HashSet<Person>();
        
        // add a selection of Person objects to the set (these are references to the Person objects 
        // which are contained as fields in this class)
        hs.add(p3);
        hs.add(p5);
        hs.add(p1);
        hs.add(p2);
        hs.add(p6);
        
        // return a reference to the newly created set
        return hs;
        
    }
        
    /**
     * Create and return a new (Hash)Set which contains a different selection of Person objects
     * 
     * @return A new HashSet object with Person objects as its content
     */
    public HashSet<Person> createSet3() 
    {     
        // create an instance of a HashSet object which is capable of containing Person objects
        HashSet<Person> hs = new HashSet<Person>();
        
        // add a selection of Person objects to the set (these are references to the Person objects 
        // which are contained as fields in this class)
        hs.add(p2);
        hs.add(p3);
        hs.add(p4);
        hs.add(p7);
        hs.add(p6);
        hs.add(p1);
        
        // return a reference to the newly created set
        return hs;
    }
   
    /**
     * Display the contents of a given set
     * 
     * @param personSet A reference to a HashSet object which contains a selection of Person objects as it contents
     */
    public void printSet(HashSet<Person> personSet)
    {
        // create a String in which the information to display will be gradually added to
       String output = "{";
           
       // get an Iterator for the set
       Iterator<Person> iterator = personSet.iterator();
       
       // while there is another item in the set to iterate over
       while (iterator.hasNext())
       {
           // get the next Person in the set
           Person p = iterator.next();
           
           // add details of this person to the String which is gradually being built           
           output = output + p.getName() + ",";
       }
       
       // NOTE: alternative to the above Iterator is to use a 'for each' loop in Java as below:
       //        
       // for (Person p : personSet) 
       // {
       //     output = output + p.getName() + ",";
       // }
       
       // add final character to output string
       output += "}";  
       
       // display the output string
       System.out.println(output);
    }
}
