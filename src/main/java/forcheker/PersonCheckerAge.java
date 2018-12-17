package forcheker;

import forwork.Person;

public class PersonCheckerAge implements PersonChecker {
    /**
     * Method for compare two value
     * @param p     first object {@link Person}
     * @param value second value
     * @return true if age {@link Person#age} = value
     */
    public boolean check(Person p, Object value) {
        return p.getAge() == (Integer) value;
    }
}
