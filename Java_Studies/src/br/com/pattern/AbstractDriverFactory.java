package br.com.pattern;

public abstract class AbstractDriverFactory {

    protected abstract String getDriverName();

    protected abstract void startService();

    protected abstract void stopService();

    protected abstract void createDriver();
}
