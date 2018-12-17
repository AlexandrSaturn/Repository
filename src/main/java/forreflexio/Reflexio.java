package forreflexio;

import forsort.SortMetod;
import forwork.RepositorArray;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Class which realize reflexio
 */
public class Reflexio {
    /**
     * Method for sort repositor rep
     * @param rep   {@link RepositorArray} array for sort
     * @param sortMetod name sort method
     */
    public static void setSortMetod(RepositorArray rep, String sortMetod){

        SortMetod sortClass = null;

        try {

            Class newClass = Class.forName(sortMetod);
            sortClass = (SortMetod) newClass.newInstance();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        try{
            Field field = rep.getClass().getDeclaredField("sort");
            field.setAccessible(true);
            field.set(rep,sortClass);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for chose field for comparator
     * @param rep   {@link RepositorArray}
     * @param sortField field for sort
     */
    public static void sortForField(RepositorArray rep, String sortField){
        try{
            Method method = rep.getClass().getDeclaredMethod(sortField);
            method.setAccessible(true);
            method.invoke(rep);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }







}
