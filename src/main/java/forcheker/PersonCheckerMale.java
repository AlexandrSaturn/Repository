package forcheker;

import forwork.Person;
import org.apache.log4j.Logger;

public class PersonCheckerMale implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonCheckerMale.class);
    public boolean check(Person p, Object value) {
        log.info("check Person " + p.getMale() + " with " + value.toString());
        return (p.getMale().equals(value));
    }
}
