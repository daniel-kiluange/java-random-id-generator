package com.kiluange.generator;

class Prefix implements Component{

    private String prefix;

    @Override
    public String toString() {
        return "Prefix{" +
                "prefix='" + prefix + '\'' +
                '}';
    }

    public Prefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String generate() {
        return this.prefix;
    }
}
