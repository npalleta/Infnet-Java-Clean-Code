package br.com.pattern;

public class ExecuteDriver {

    public static void main(String[] args) {

        AbstractDriverFactory browserLauncherChrome = DriverManager.getDriver(new DriverFactory(), "chrome");
        AbstractDriverFactory browserLauncherFirefox = DriverManager.getDriver(new DriverFactory(), "firefox");
        AbstractDriverFactory browserLauncherEdge = DriverManager.getDriver(new DriverFactory(), "edge");
        // AbstractDriverFactory browserLauncher = DriverManager.getDriver(new DriverFactory(), "");

        browserLauncherChrome.createDriver();
        browserLauncherChrome.startService();

        browserLauncherFirefox.createDriver();
        browserLauncherFirefox.startService();

        browserLauncherChrome.stopService();

        browserLauncherFirefox.stopService();

        browserLauncherEdge.createDriver();
        browserLauncherEdge.startService();
        browserLauncherEdge.stopService();

        // browserLauncher.createDriver();
    }
}