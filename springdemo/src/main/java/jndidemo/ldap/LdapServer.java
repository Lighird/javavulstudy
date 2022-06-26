package jndidemo.ldap;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.net.InetAddress;

public class LdapServer {
    private static final String LDAP_BASE="dc=example,dc=com";
    public static void main(String[] args){
        int port=1389;
        try{
            InMemoryDirectoryServerConfig imserverConfig = new InMemoryDirectoryServerConfig(LDAP_BASE);
            imserverConfig.setListenerConfigs(new InMemoryListenerConfig(
                    "listen",
                    InetAddress.getByName("0.0.0.0"),
                    port,
                    ServerSocketFactory.getDefault(),
                    SocketFactory.getDefault(),
                    (SSLSocketFactory)SSLSocketFactory.getDefault()
            ));
            imserverConfig.setSchema(null);
            imserverConfig.setEnforceAttributeSyntaxCompliance(false);
            imserverConfig.setEnforceSingleStructuralObjectClass(false);
            InMemoryDirectoryServer imDirServer =new InMemoryDirectoryServer(imserverConfig);
            imDirServer.add("dn: "+"dc=example,dc=com","objectClass:top","objectclass:domain");
            imDirServer.add("dn: "+"ou=employees,dc=example,dc=com","objectClass:organizationalUnit","objectClass:top");
            imDirServer.add("dn: "+"uid=longofo,ou=employees,dc=example,dc=com","objectClass:ExportObject");
            System.out.println("Listening on 0.0.0.0:"+port);
            imDirServer.startListening();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
