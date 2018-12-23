package forcheker;

import forwork.Person;
import org.apache.log4j.Logger;

public class PersonCheckerFname implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonCheckerFname.class);
    public boolean check(Person p, Object value) {
        log.info("check Person " + p.getFname() + " with " + value.toString());
        return p.getAge() == (Integer) value;
    }
}
