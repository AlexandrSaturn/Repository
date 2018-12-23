package forwork;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Class for test claa RepositorArray
 * @author Alex
 */
public class RepositorArrayTest {

    RepositorArray rep=null;
    Person p1 = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
    Person p2 = new Person(2,"Alex","man",new LocalDate(1997,11,17));
    Person p3 = new Person(3,"Lui","man",new LocalDate(2001,11,17));
    Person p4 = new Person(4,"Oliver","man",new LocalDate(2000,9,11));
    Person p5 = new Person(5,"Megan","woman",new LocalDate(2000,11,17));
    Person p6 = new Person(6,"Alex","woman",new LocalDate(1997,1,12));
    Person p7 = new Person(1,"Alla","woman",new LocalDate(2000,3,17));

    /**
     * function which work before every @Test
     */
    @Before
    public void setUp(){
        rep = new RepositorArray();
    }

    /**
     * function which work after every @Test
     */
    @After
    public void tearDown(){
        rep = null;
    }

    /**
     * Test for method getLengthA
     */
    @Test
    public void getLengthA() {
        assertTrue(rep.getLengthA()==0);
        rep.add(p1);
        assertTrue(rep.getLengthA()==1);
        rep.add(p2);
        assertTrue(rep.getLengthA()==2);
        rep.deletePerson(p1.getId());
        assertTrue(rep.getLengthA()==1);
    }

    /**
     * Test for method add
     */
    @Test
    public void add() {
        assertTrue(rep.getLengthA()==0);
        rep.add(p1);
        assertTrue(rep.getLengthA()==1);
        rep.add(p2);
        assertTrue(rep.getLengthA()==2);

        assertTrue(p1.equals(rep.getPerson(1)));
        assertTrue(p2.equals(rep.getPerson(1))==false);

    }

    /**
     * Test for method deletePerson
     */
    @Test
    public void deletePerson() {
        assertTrue(rep.getLengthA()==0);
        rep.add(p1);
        assertTrue(rep.getLengthA()==1);
        rep.add(p2);
        assertTrue(rep.getLengthA()==2);
        rep.deletePerson(p1.getId());

        assertEquals(null,rep.getPerson(p1.getId()));

        assertTrue(rep.getLengthA()==1);

        assertEquals(p2,rep.getPerson(p2.getId()));
        rep.deletePerson(p2);

        assertTrue(rep.getLengthA()==0);

    }

    /**
     * Test for method getPerson
     */
    @Test
    public void getPerson() {
        rep.add(p1);
        Person expected = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
        Person actual = rep.getPerson(1);
        assertEquals(expected,actual);
    }

    /**
     * Test for method searchById
     */
    @Test
    public void searchById() {
        rep.add(p1);
        rep.add(p2);
        rep.add(p3);
        rep.add(p7);
        RepositorArray actual = rep.searchById(1);
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        expected.add(p7);
        assertTrue(expected.equals(actual));
    }

    /**
     * Test for method searchByFname
     */
    @Test
    public void searchByFname() {
        rep.add(p1);
        rep.add(p2);
        rep.add(p3);
        RepositorArray actual = rep.searchByFname("Vlad");
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        assertTrue(expected.equals(actual));
    }

    /**
     * Test for method searchMale
     */
    @Test
    public void searchMale() {
        rep.add(p1);
        rep.add(p2);
        rep.add(p3);
        RepositorArray actual = rep.searchMale("man");
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        expected.add(p2);
        expected.add(p3);
        assertTrue(expected.equals(actual));
    }

    /**
     * Test for method searchByBirthday
     */
    @Test
    public void searchByBirthday() {
        rep.add(p1);
        rep.add(p2);
        rep.add(p3);
        RepositorArray actual = rep.searchByBirthday(new LocalDate(1995,11,17));
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        assertTrue(expected.equals(actual));
    }

    /**
     * Test for method searchAge
     */
    @Test
    public void searchAge() {
        rep.add(p1);
        rep.add(p2);
        rep.add(p3);
        RepositorArray actual = rep.searchAge(23);
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        assertTrue(expected.equals(actual));
    }

    /**
     * Test for method sortId
     */
    @Test
    public void sortId() {
        rep.add(p3);
        rep.add(p2);
        rep.add(p1);
        rep.sortId();
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        expected.add(p2);
        expected.add(p3);
        assertTrue(expected.equals(rep));
    }

    /**
     * Test for method sortFname
     */
    @Test
    public void sortFname() {
        rep.add(p1);
        rep.add(p2);
        rep.add(p3);
        rep.sortFname();
        RepositorArray expected = new RepositorArray();
        expected.add(p2);
        expected.add(p3);
        expected.add(p1);
        assertTrue(expected.equals(rep));
    }

    /**
     * Test for method sortMale
     */
    @Test
    public void sortMale() {
        rep.add(p1);
        rep.add(p6);
        rep.add(p2);
        rep.sortMale();
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        expected.add(p2);
        expected.add(p6);
        assertTrue(expected.equals(rep));
    }

    /**
     * Test for method sortBirthday
     */
    @Test
    public void sortBirthday() {
        rep.add(p1);
        rep.add(p6);
        rep.add(p2);
        rep.sortBirthday();
        RepositorArray expected = new RepositorArray();
        expected.add(p1);
        expected.add(p6);
        expected.add(p2);
        assertTrue(expected.equals(rep));
    }

    /**
     * Test for method sortAge
     */
    @Test
    public void sortAge() {
        rep.add(p1);
        rep.add(p6);
        rep.add(p2);
        rep.sortAge();
        RepositorArray expected = new RepositorArray();
        expected.add(p6);
        expected.add(p2);
        expected.add(p1);
        assertTrue(expected.equals(rep));
    }
}