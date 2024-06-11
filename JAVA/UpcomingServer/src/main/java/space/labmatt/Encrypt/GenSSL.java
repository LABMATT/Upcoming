package space.labmatt.Encrypt;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

public class GenSSL {
    public SSLContext getKey() throws Exception {

        // load up the key store
        String STORETYPE = "JKS";
        String STOREPASSWORD = "Astrix10";
        String KEYPASSWORD = "Astrix10";

        KeyStore keystore = KeyStore.getInstance(STORETYPE);
        File keyfile = new File("C:\\xampp\\htdocs\\CaptainsLog\\Java\\Clog\\src\\main\\java\\labmatt\\space\\keystore.jks");
        keystore.load(new FileInputStream(keyfile), STOREPASSWORD.toCharArray());

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(keystore, KEYPASSWORD.toCharArray());
        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(keystore);

        SSLContext sslContext = null;
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        return sslContext;
    }
}
