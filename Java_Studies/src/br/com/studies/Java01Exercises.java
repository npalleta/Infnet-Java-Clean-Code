package br.com.studies;

public class Java01Exercises {
    public String text;
    public Java01Exercises(String text) {
        this.text = text;
    }

    public Java01Exercises getTextA() {
        this.text = this.text.concat("efg");
        return this;
    }

    public Java01Exercises getTextB() {
        this.text = this.text.concat("hij");
        return this;
    }
}
