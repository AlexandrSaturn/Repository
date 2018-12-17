package forwork;

import forcheker.PersonChecker;
import forcheker.PersonCheckerAge;
import forcheker.PersonCheckerBirthday;
import forcheker.PersonCheckerId;
import forsort.SortMetod;
import org.joda.time.LocalDate;

/**
 * Class for work with class person. Have fields: <b>arr</b>, <b>length</b>, <b>sort</b> Realize array list for person
 * @author Kisa Alexandr
 * @version 1.0.3
 */
public class RepositorArray {
    /**
     * array with element = person
     */
    private Person[] arr;
    /**
     * array length
     */
    private int lengthA;
    /**
     * Method for sort array
     */
    private SortMetod sort;

    /**
     * constructor - create new object with count elem = 0
     * @see RepositorArray#RepositorArray(SortMetod)
     */
    public RepositorArray(){
        lengthA=0;
        arr=new Person[10];
    }

    /**
     *  constructor - create new object with count elem = 0 and sort method like sort
     * @param sort  sort method
     */
    public RepositorArray(SortMetod sort){
        lengthA=0;
        arr=new Person[10];
        this.sort = sort;
    }

    /**
     * Method for add new element in array
     * @param p - new elem
     */
    public void add(Person p) {
        if (lengthA < arr.length) {
            arr[lengthA] = new Person(p);
            lengthA++;
        }
        else {
            Person[] new_arr = new Person[(int) (arr.length * 1.5)];

            for (int i = 0; i < arr.length; i++)
                new_arr[i] = new Person(arr[i]);

            new_arr[arr.length] = new Person(p);

            arr = new_arr;
        }
    }

    /**
     * Method for write all elements from array in console
     */
    public void println(){
        if (arr!=null)
            for (int i=0;i<lengthA;i++)
                arr[i].println();
    }

    /**
     * Method for get Person from array with {@link Person#id} = id
     * @param id    identifier Person
     * @return  person with this id if search is successfulm, else - null
     */
    public Person getPerson(int id){
        boolean search = false;
        int i=0;
        while (!search && i<lengthA){
            search = (arr[i].getId()==id);
            i++;
        }
        if (search)
            return arr[i-1];
        else
            return null;
    }

    /**
     * Method for get index person p {@link Person} in array
     * @param p person
     * @return  index in array
     */
    private int getIndex(Person p){
        boolean search = false;
        int i=0;
        while (!search && i<lengthA){
            search = (arr[i].equals(p));
            i++;
        }
        if (search)
            return i-1;
        else
            return -1;
    }

    /**
     * Method for get index person with id {@link Person#id} in array
     * @param id identifier fro person
     * @return index in array
     */
    private int getIndex(int id){
        boolean search = false;
        int i=0;
        while (!search && i<lengthA){
            search = (arr[i].getId()==id);
            i++;
        }
        if (search)
            return i-1;
        else
            return -1;
    }

    /**
     * Mathod for delete person with id {@link Person#id} from array
     * @param id    identifier for person
     */
    public void deletePerson(int id){
        int index=getIndex(id);

        if (index > -1){
            for (int i=index;i<lengthA-1;i++)
                arr[i].Copy(arr[i+1]);
        }
        lengthA--;
        arr[lengthA]=null;
    }

    /**
     * Method for delete person p with id {@link Person#id} from array
     * @param p person
     */
    public void deletePerson(Person p){
        int index=getIndex(p);

        if (index > -1){
            for (int i=index;i<lengthA-1;i++)
                arr[i].Copy(arr[i+1]);
        }
        lengthA--;
        arr[lengthA]=null;
    }

    /**
     * Method fro get {@link RepositorArray#lengthA}
     * @return  length array
     */
    public int getLengthA(){
        return lengthA;
    }

    /**
     * Method for swap elements with index i and j in array
     * @param i first element
     * @param j second element
     */
    public void swapElem (int i, int j){
        Person p = arr[i];
        arr[i]=arr[j];
        arr[j]=p;
    }

    /**
     * Method for search elements in arrray with different comparators
     * @param checker   interface  {@link PersonChecker}which implement different comparators
     * @param value value for search
     * @return  array with elements
     */

    private RepositorArray search(PersonChecker checker, Object value) {
        RepositorArray resultArr = new RepositorArray();
        for (int i = 0; i < lengthA; i++) {
            if (checker.check(arr[i], value))
                resultArr.add(arr[i]);

        }
        return resultArr;
    }


    /**
     * Method for search by id {@link Person#id}
     * @param id {@link Person#id}for search
     * @return  array with elements
     */
    public RepositorArray searchById(int id){
        return search(new PersonCheckerId(),id);
    }


    /**
     * Method for search by fname {@link Person#fname}
     * @param fname {@link Person#fname}for search
     * @return  array with elements
     */
    public RepositorArray searchByFname (String fname){
        return search((p,a) -> p.getFname().equals(a),fname);
    }

    /**
     * Method for search by male {@link Person#male}
     * @param male  {@link Person#male} for search
     * @return  {@link RepositorArray} array with elements
     */
    public RepositorArray searchMale (String male){
        return search((p,a) -> p.getMale().equals(a),male);
    }

    /**
     * Method for search by birthday {@link Person#birthday}
     * @param birthday  {@link Person#birthday} for search
     * @return  {@link RepositorArray} array with elements
     */
    public RepositorArray searchByBirthday (LocalDate birthday){
        return search(new PersonCheckerBirthday(), birthday);
    }

    /**
     * Method for search by age {@link Person#age}
     * @param age  {@link Person#age} for search
     * @return  {@link RepositorArray} array with elements
     */
    public RepositorArray searchAge (int age){
        return search(new PersonCheckerAge(), age);
    }

    /**
     * Mathod which realize sort array
     * @param comp  interface {@link Compare}
     */
    private void sort(Compare comp){
        sort.sort(arr,lengthA, comp);
    }

    /**
     * Method for sort array by id {@link Person#id}
     */
    public void sortId(){
        sort(new CompareId());
    }

    /**
     * Method for sort array by fname {@link Person#fname}
     */
    public void sortFname(){
        sort((p1,p2) -> p1.getFname().compareTo(p2.getFname()) > 0  ? 1 : (p1.getFname().equals(p2.getFname()) ? 0 : -1));
    }

    /**
     * Method for sort array by male {@link Person#male}
     */
    public void sortMale(){
        sort((p1,p2) -> p1.getMale().compareTo(p2.getMale()) > 0  ? 1 : (p1.getMale().equals(p2.getMale()) ? 0 : -1));
    }

    /**
     * Method for sort array by birthday {@link Person#birthday}
     */
    public void sortBirthday(){
        sort((p1,p2) -> p1.getBirthday().compareTo(p2.getBirthday()) > 0 ? 1 : (p1.getBirthday().equals(p2.getBirthday()) ? 0 : -1) );
    }

    /**
     * Method for sort array by age {@link Person#age}
     */
    public void sortAge(){
        sort((p1,p2) -> p1.getAge() > p2.getAge() ? 1 : (p1.getAge()==p2.getAge() ? 0 : -1) );
    }

}

