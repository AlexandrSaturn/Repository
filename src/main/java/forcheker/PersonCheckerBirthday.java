package forcheker;

import forwork.Person;

public class PersonCheckerBirthday implements PersonChecker {
    public boolean check(Person p, Object value) {
        return (p.getBirthday().equals(value));
    }
}
