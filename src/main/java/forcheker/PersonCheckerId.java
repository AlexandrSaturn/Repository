package forcheker;

import forwork.Person;
import org.apache.log4j.Logger;

public class PersonCheckerId implements PersonChecker{
    private static final Logger log = Logger.getLogger(PersonCheckerId.class);
    public boolean check(Person p, Object value) {
        log.info("check Person " + p.getId() + " with " + value.toString());
        return ( p.getId() == (Integer) value);
    }
}
