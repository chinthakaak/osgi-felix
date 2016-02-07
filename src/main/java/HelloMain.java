import java.util.HashMap;
import java.util.Map;

import org.apache.felix.framework.*;
import org.osgi.framework.*;
/**
 * Created by ka40215 on 2/7/16.
 */
public class HelloMain {
    public static void main(String[] args) throws BundleException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Map configMap = new HashMap();
        configMap.put(Constants.FRAMEWORK_STORAGE_CLEAN, "onFirstInit");

        Felix framework = new Felix(configMap);
        framework.init();

        final BundleContext bundleContext = framework.getBundleContext();

        Bundle serverBundle = bundleContext.installBundle("file:server/target/server-1.0-SNAPSHOT.jar");
        Bundle clientBundle = bundleContext.installBundle("file:client/target/client-1.0-SNAPSHOT.jar");

        framework.start();

        clientBundle.loadClass("com.examples.HelloClient").newInstance();
        framework.stop();

    }
}
