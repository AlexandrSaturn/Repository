package forcheker;

import forwork.Person;

/**
 * Interface for comparision
 */
public interface PersonChecker {
        /**
         * Method for comparision
         * @param p     first object {@link Person}
         * @param value second value
         * @return      true, if elements equal
         */
        public boolean check(Person p, Object value);
}
