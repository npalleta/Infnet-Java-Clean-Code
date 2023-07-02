package br.com.pattern;

public class ChromeDriver extends AbstractDriverFactory {

    @Override
    protected String getDriverName() {
        return "chrome";
    }

    @Override
    protected void startService() {
        System.out.println("Iniciando o serviço do ChromeDriver");
    }

    @Override
    protected void stopService() {
        System.out.println("Parando o serviço do ChromeDriver");
    }

    @Override
    protected void createDriver() {
        System.out.println("Criando um browser do ChromeDriver");
    }
}