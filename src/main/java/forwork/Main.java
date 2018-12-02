package forwork;

import org.joda.time.LocalDate;


public class Main {

    public static void main(String[] arg){

       /* LocalDate currentTime = new LocalDate();
        LocalDate date1 = new LocalDate(2018,1,11);
        System.out.println(date1.getYear());
        System.out.println(date1.getMonthOfYear());
        System.out.println(date1.getDayOfMonth());
        */



        RepositorArray array = new RepositorArray();
        Person p1 = new Person(1,"Vlad","man",new LocalDate(1995,11,17));
        Person p2 = new Person(2,"Alex","man",new LocalDate(2000,11,17));
        Person p3 = new Person(3,"Lui","man",new LocalDate(2000,11,17));
        Person p4 = new Person(4,"Megan","woman",new LocalDate(2000,11,17));

        array.add(p1);
        array.add(p2);
        array.add(p3);
        array.add(p4);
        array.deletePerson(p2);
        array.deletePerson(1);
        array.add(p1);
        array.deletePerson(1);
        array.println();

    }
}
