package forcheker;

import forwork.Person;

public class PersonCheckerId implements PersonChecker{
    public boolean check(Person p, Object value) {
        return ( p.getId() == (Integer) value);
    }
}
