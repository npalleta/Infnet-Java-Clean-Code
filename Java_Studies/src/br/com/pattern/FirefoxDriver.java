package br.com.pattern;

public class FirefoxDriver extends AbstractDriverFactory {

    @Override
    protected String getDriverName() {
        return "firefox";
    }
    @Override
    protected void startService() {
        System.out.println("Iniciando o serviço do FirefoxDriver");
    }

    @Override
    protected void stopService() {
        System.out.println("Parando o serviço do FirefoxDriver");
    }

    @Override
    protected void createDriver() {
        System.out.println("Criando um browser do FirefoxDriver");
    }
}
