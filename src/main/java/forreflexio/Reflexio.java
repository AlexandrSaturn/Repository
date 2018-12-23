package forreflexio;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Class for realize reflexio for field
 * @author Kisa Alexandr
 * @version 1.0
 */
public class Reflexio{
    private static final Logger log = Logger.getLogger(Reflexio.class);
    /**
     * function, which set sorter from config.properties
     * @param obj   instance of class contains sorter
     */
    public void setSortMetod(Object obj){
        log.info("set field with annotation "+ Injector.class.getName()+ " new value");
        Properties prop = new Properties();
        FileInputStream fis;
        String fileName = "src/main/resources/config.properties";
        try{
            fis = new FileInputStream(fileName);
            prop.load(fis);

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Injector.class)){
                    String fieldName = f.getType().getName();
                    try {
                        Class newClass = Class.forName(prop.getProperty(fieldName));
                        f.setAccessible(true);
                        f.set(obj,newClass.newInstance());


                    } catch (ClassNotFoundException e) {
                        log.error("class with name " + prop.getProperty(fieldName) + "not found ");
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        log.error("error setAccessible on field "+f.getName());
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        log.error("can't set field " + f.getName());
                        e.printStackTrace();
                    }
                }

            }

        } catch (FileNotFoundException e) {
            log.error("can't found file " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("can't load file");
            e.printStackTrace();
        }


    }












}
