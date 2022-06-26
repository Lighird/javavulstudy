package jndidemo.ldap.Ref;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
public class LdapRefClient {
    public static void main(String[] args) throws NamingException {
        System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase","true");
        Context ctx = new InitialContext();
        Object object = ctx.lookup("ldap://127.0.0.1:1389/uid=longofo,ou=employees,dc=example,dc=com");
    }
}
