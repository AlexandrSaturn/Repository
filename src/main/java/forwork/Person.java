package forwork;

import org.joda.time.LocalDate;

public class Person implements PersonChecker{

    private int id;

    private String fname;

    private String male;

    private LocalDate birthday;

    private int age;

    public Person(int id, String fname, String male, LocalDate birthday) {
        this.id = id;
        this.fname = fname;
        this.male = male;
        this.birthday = birthday;
        this.age = 0;

        LocalDate today = LocalDate.now();

        if (today.getYear() > birthday.getYear()) {
            this.age =today.getYear() - birthday.getYear();
            if(today.getMonthOfYear() > birthday.getMonthOfYear())
                this.age--;
            else
            if ( today.getMonthOfYear() == birthday.getMonthOfYear() && today.getDayOfMonth() < birthday.getDayOfMonth() )
                this.age--;
        }

    }

    public Person(Person p) {
        this.id = p.id;
        this.fname = p.fname;
        this.male = p.male;
        this.birthday = p.birthday;
        this.age = p.age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFio(String fname) {
        this.fname = fname;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;

        LocalDate today = LocalDate.now();

        if (today.getYear() > birthday.getYear()) {
            this.age =today.getYear() - birthday.getYear();
            if(today.getMonthOfYear() > birthday.getMonthOfYear())
                this.age--;
            else if ( today.getMonthOfYear() == birthday.getMonthOfYear() && today.getDayOfMonth() < birthday.getDayOfMonth() )
                this.age--;
        }

    }

    public int getAge() {
        return age;
    }

    public void println(){
        System.out.println(this.id);
        System.out.println(this.fname);
        System.out.println(this.male);
        System.out.println(this.birthday);
        System.out.println(this.age);
        System.out.println();
    }

    public void Copy(Person p) {
        this.id = p.id;
        this.fname = p.fname;
        this.male = p.male;
        this.birthday = p.birthday;
        this.age = p.age;
    }

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

    public boolean check(Person p, Object value) {
        return false;
    }
}
