package jndidemo.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class RmiClient {
    public static void main(String[] args) throws NamingException {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        Context ctx = new InitialContext();
        //DirContext dirc=new InitialDirContext();
        ctx.lookup("rmi://127.0.0.1:1099/refObj");
    }
}
