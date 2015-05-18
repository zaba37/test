/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.interceptor.logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
//import org.apache.log4j.Logger;
//import org.apache.log4j.Priority;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/**
 *
 * @author zaba37
 */
public class interceptor {
    static Logger logger = Logger.getLogger(interceptor.class.getName());
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    
    @AroundInvoke
    public Object intercept(InvocationContext ic) throws Exception{
        Object ret = ic.proceed();
        logger.setLevel(Level.INFO);
        //fileTxt = new FileHandler("C:\\Users\\zaba37\\Documents\\NetBeansProjects\\zadanie8\\zadanie8-ejb\\log\\Logging.txt");
        fileTxt=new FileHandler("C:\\Users\\zaba37\\Documents\\NetBeansProjects\\zadanie8\\zadanie8-ejb\\log\\Logging.txt",1000000,1,true);
        logger.addHandler(fileTxt);
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        System.out.println("Get called for method: " + ic.getMethod());  
        logger.info(logger.getName() + " Wywołano " + ic.getMethod());
        System.out.println("Called method complited.");
        fileTxt.close();
        return ret;
    }
}
