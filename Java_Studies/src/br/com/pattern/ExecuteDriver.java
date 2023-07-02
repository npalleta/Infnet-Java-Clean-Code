package br.com.pattern;

public class ExecuteDriver {

    public static void main(String[] args) {

        AbstractDriverFactory browserLauncherChrome = DriverManager.getDriver(new DriverFactory(), "chrome");
        AbstractDriverFactory browserLauncherFirefox = DriverManager.getDriver(new DriverFactory(), "firefox");
        AbstractDriverFactory browserLauncherEdge = DriverManager.getDriver(new DriverFactory(), "edge");

        browserLauncherChrome.createDriver();

        browserLauncherFirefox.startService();

        browserLauncherEdge.stopService();
    }
}