package br.com.pattern;

public interface IAbstractFactoryDriver {
    public AbstractDriverFactory buildDriver(String driverName);
}
