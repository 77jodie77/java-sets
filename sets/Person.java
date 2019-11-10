import java.util.Date;

/**
 * Records information for a person
 */
public class Person
{
    private String name; // the person's name
    private Date dateCreated; // the date that a Person object has been created

    /**
     * Constructor
     * 
     * @param name The name to give the person
     */
    public Person(String name)
    {
        // initialise instance variables
        this.name = name;
        
        // when a Date object is created it automatically records the current date and time within it
        dateCreated = new Date();
    }
    
    /**
     * Get the person's name
     * 
     * @return A String containing the person's name
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Get the date / time that this person object was created
     * 
     * @return A Date object which contains the date and time that the object was created
     */
    public Date getDateCreated()
    {
        return dateCreated;
    }

    /**
     * Display details of the person
     */
    public void printDetails() 
    {        
        System.out.println("This person is called " + name);
    }
}