package forwork;

import org.joda.time.LocalDate;

/**
 * Class with fields <b>id</b>, <b>fname</b> , <b>male</b> , <b>birthday</b>, <b>age</b>
 * @author Kisa Alexand
 * @version 1.0 realize
 *
 */
public class Person{
    /** field identifier */
    private int id;
    /** field ful name */
    private String fname;
    /** field person male */
    private String male;
    /** field birthday in format dd-mm-yyyy */
    private LocalDate birthday;
    /** field person age */
    private int age;

    /**
     * constructor - create new object
     * @see Person#Person(Person)
     * @param id    identifier for person
     * @param fname full name
     * @param male  male
     * @param birthday  birthday
     */
    public Person(int id, String fname, String male, LocalDate birthday) {
        this.id = id;
        this.fname = fname;
        this.male = male;
        this.birthday = birthday;
        this.age = getAge();

    }

    /**
     * constructor - create new object
     * @param p person with copy parameters
     */
    public Person(Person p) {
        this.id = p.id;
        this.fname = p.fname;
        this.male = p.male;
        this.birthday = p.birthday;
        this.age = p.age;
    }

    /**
     * Get field id {@link Person#id}
     * @return  id - identifier
     */
    public int getId() {
        return id;
    }

    /**
     * Set field id {@link Person#id}
     * @param id  - identifier
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get field fname  {@link Person#fname}
     * @return fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * Set field fname {@link Person#fname}
     * @param fname - full name
     */
    public void setFio(String fname) {
        this.fname = fname;
    }

    /**
     * Get field male {@link Person#male}
     * @return male
     */
    public String getMale() {
        return male;
    }

    /**
     * Set field male {@link Person#male}
     * @param male
     */
    public void setMale(String male) {
        this.male = male;
    }

    /**
     * Get field birthday   {@link Person#birthday}
     * @return birthday
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Set field birthday   {@link Person#birthday}
     * @param birthday
     */
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /**
     * Get field age {@link Person#age}.   Need for set new age for person
     * @return age
     */
    public int getAge() {

        LocalDate today = LocalDate.now();

        if (today.getYear() > birthday.getYear()) {
            this.age =today.getYear() - birthday.getYear();
            if(today.getMonthOfYear() > birthday.getMonthOfYear())
                this.age--;
            else
            if ( today.getMonthOfYear() == birthday.getMonthOfYear() && today.getDayOfMonth() < birthday.getDayOfMonth() )
                this.age--;
        }
        return age;
    }

    /**
     *  Method for write all fields in console
     */
    public void println(){
        System.out.println(this.id);
        System.out.println(this.fname);
        System.out.println(this.male);
        System.out.println(this.birthday);
        System.out.println(this.age);
        System.out.println();
    }

    /**
     * Method for copy all fields from person p
     * @param p
     */
    public void Copy(Person p) {
        this.id = p.id;
        this.fname = p.fname;
        this.male = p.male;
        this.birthday = p.birthday;
        this.age = p.age;
    }

    /**
     * realize method equals
     * @param o objject for comparison
     * @return  true if equals, elst false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        if (age != person.age) return false;
        if (fname != null ? !fname.equals(person.fname) : person.fname != null) return false;
        if (male != null ? !male.equals(person.male) : person.male != null) return false;
        return birthday != null ? birthday.equals(person.birthday) : person.birthday == null;
    }

}
