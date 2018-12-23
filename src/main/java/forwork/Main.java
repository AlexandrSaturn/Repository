package forwork;
import org.joda.time.LocalDate;

import org.apache.log4j.Logger;

/**
 * Class for work with other classes =)
 * download parametres from config.properties for work with RepositorArray
 * @author Kisa Alexandr
 * @version 0.0001
 */

public class Main {
    public static Logger log = Logger.getLogger(Main.class);
    /**
     * main method for all our kingdom
     * @param arg   string with some arguments
     */
    public static void main(String[] arg){
        log.info("Start main class"+Main.class.getName());

        RepositorArray array = new RepositorArray();

        Person p1 = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
        Person p2 = new Person(2,"Alex","man",new LocalDate(1997,11,17));
        Person p3 = new Person(3,"Lui","man",new LocalDate(2001,11,17));
        Person p4 = new Person(4,"Oliver","man",new LocalDate(2000,9,11));
        Person p5 = new Person(5,"Megan","woman",new LocalDate(2000,11,17));
        Person p6 = new Person(6,"Alex","woman",new LocalDate(1997,1,12));
        Person p7 = new Person(7,"Alla","woman",new LocalDate(2000,3,17));

        array.add(p7);
        array.add(p4);
        array.add(p5);
        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);
        array.add(p1);
        array.add(p6);
        array.deletePerson(p2);
        array.sortFname();
        //array.println();
    }
}



