package jndidemo.ldap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class LdapClient {
    public static void main(String[] args) throws NamingException {
        Hashtable env=new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://127.0.0.1:1389/dc=example,dc=com");
        Context ctx = new InitialContext(env);
        Object object = ctx.lookup("foo=any");
    }
}
