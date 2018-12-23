package forcheker;

import forwork.Person;
import org.apache.log4j.Logger;

public class PersonCheckerAge implements PersonChecker {
    private static final Logger log = Logger.getLogger(PersonCheckerAge.class);
    /**
     * Method for compare two value
     * @param p     first object {@link Person}
     * @param value second value
     * @return true if age {@link Person#age} = value
     */
    public boolean check(Person p, Object value) {
        log.info("check Person " + p.getAge() + " with " + value.toString());
        return p.getAge() == (Integer) value;
    }
}
