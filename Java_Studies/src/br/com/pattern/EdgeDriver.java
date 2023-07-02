package br.com.pattern;

public class EdgeDriver extends AbstractDriverFactory {

    @Override
    protected String getDriverName() {
        return "edge";
    }

    @Override
    protected void startService() {
        System.out.println("Iniciando o serviço do EdgeDriver");
    }

    @Override
    protected void stopService() {
        System.out.println("Parando o serviço do EdgeDriver");
    }

    @Override
    protected void createDriver() {
        System.out.println("Criando um browser do EdgeDriver");
    }
}