package forcheker;

import forwork.Person;

public class PersonCheckerFname implements PersonChecker {
    public boolean check(Person p, Object value) {
        return p.getAge() == (Integer) value;
    }
}
