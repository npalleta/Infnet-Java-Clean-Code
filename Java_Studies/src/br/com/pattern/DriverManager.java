package br.com.pattern;

public class DriverManager {

    public static AbstractDriverFactory getDriver(DriverFactory driverFactory, String driverName) {
        return driverFactory.buildDriver(driverName);
    }
}
