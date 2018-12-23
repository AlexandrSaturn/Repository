package forcheker;

import forwork.Person;
import org.apache.log4j.Logger;

public class PersonCheckerBirthday implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonCheckerBirthday.class);
    public boolean check(Person p, Object value) {
        log.info("check Person " + p.getBirthday() + " with " + value.toString());
        return (p.getBirthday().equals(value));
    }
}
