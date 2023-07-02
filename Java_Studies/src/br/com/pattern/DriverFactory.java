package br.com.pattern;

public class DriverFactory implements IAbstractFactoryDriver {

    static AbstractDriverFactory driverFactory;

    @Override
    public AbstractDriverFactory buildDriver(String driverName) {

        switch (driverName) {
            case "chrome":
                driverFactory = new ChromeDriver();
            case "edge":
                driverFactory = new EdgeDriver();
                break;
            case "firefox":
                driverFactory = new FirefoxDriver();
                break;
            default:
                System.out.println(String.format("Você não selecionou um driver existente: %s", driverName));
        }

        return driverFactory;
    }
}
