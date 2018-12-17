package forcheker;

import forwork.Person;

public class PersonCheckerMale implements PersonChecker {
    public boolean check(Person p, Object value) {
        return (p.getMale().equals(value));
    }
}
