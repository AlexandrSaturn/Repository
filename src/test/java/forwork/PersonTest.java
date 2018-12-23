package forwork;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class for test class Person
 * @author Alexandr
 */
public class PersonTest {
    /**
     * Field for test
     */
    Person person;


    /**
     *  function which work before every @Test
     */
    @Before
    public void setUp(){
        person = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
    }

    /**
     *  function which work after every @Test
     */
    @After
    public void tearDown(){
        person = null;
    }

    /**
     * Test getId
     */
    @Test
    public void getId() {
        int expected = 1;
        int actual = person.getId();
        assertEquals(expected,actual);
    }

    /**
     * Text getFname
     */
    @Test
    public void getFname() {
        String expected = "Vlad" ;
        String actual = person.getFname();
        assertEquals(expected,actual);
    }

    /**
     * Test getMale
     */
    @Test
    public void getMale() {
        String expected = "man" ;
        String actual = person.getMale();
        assertEquals(expected,actual);
    }

    /**
     * Test get Birthday
     */
    @Test
    public void getBirthday() {
        LocalDate expected = new LocalDate(1995,11,17) ;
        LocalDate actual = person.getBirthday();
        assertEquals(expected,actual);
    }

    /**
     * Test getAge
     */
    @Test
    public void getAge() {
        int expected = 22;
        int actual = person.getAge();
        assertEquals(expected,actual);
    }

    /**
     * Test setId
      */
    @Test
    public void setId() {
        int expected = 2;
        person.setId(expected);
        int actual = person.getId();
        assertEquals(expected,actual);
    }

    /**
     * Test stFname
     */
    @Test
    public void setFname() {
        String expected = "Sasha" ;
        person.setFio(expected);
        String actual = person.getFname();
        assertEquals(expected,actual);
    }

    /**
     * Test setMale
     */
    @Test
    public void setMale() {
        String expected = "woman" ;
        person.setMale(expected);
        String actual = person.getMale();
        assertEquals(expected,actual);
    }

    /**
     * Test stBirthday
     */
    @Test
    public void setBirthday() {
        LocalDate expected = new LocalDate(1996,10,15) ;
        person.setBirthday(expected);
        LocalDate actual = person.getBirthday();
        assertEquals(expected,actual);
    }

    /**
     * Test equals for different persons
     */
    @Test
    public void equals() {
        Person p1 = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
        Person p2 = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
        Person p3 = new Person(3,"Lui","man",new LocalDate(2001,11,17));
        Person p4 = new Person(3,"Lui","man",new LocalDate(2001,11,17));
        Person p5 = new Person(5,"Megan","woman",new LocalDate(2000,11,17));
        Person p6 = new Person(5,"Megan","woman",new LocalDate(2000,11,17));

        assertEquals(true,p1.equals(p2));
        assertEquals(true,p2.equals(p1));
        assertEquals(false,p2.equals(p3));
        assertEquals(true,p3.equals(p4));
        assertEquals(true,p5.equals(p6));
        assertEquals(false,p1.equals(p6));
    }
}