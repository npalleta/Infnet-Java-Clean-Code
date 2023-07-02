package br.com.pattern;

import javax.swing.*;
import java.util.Arrays;

public class DriverFactory implements IAbstractFactoryDriver {

    private AbstractDriverFactory driverFactory;

    @Override
    public AbstractDriverFactory buildDriver(String driverName) {

        if (driverName.equals("chrome")) {
            driverFactory = new ChromeDriver();
        } else if (driverName.equals("edge")) {
            driverFactory = new EdgeDriver();
        } else if (driverName.equals("firefox")) {
            driverFactory = new FirefoxDriver();
        } else if (!Arrays.asList("chrome", "firefox", "edge").contains(driverName)) {
            driverFactory = null;
            JOptionPane.showMessageDialog(
                new JFrame(),
                String.format("Você tentou incluir um driver inexistente: %s", driverName),
                "# ERROR! #",
                JOptionPane.ERROR_MESSAGE
            );
        }

        if (driverFactory == null) {
            System.exit(0);
        }

        return driverFactory;
    }
}
