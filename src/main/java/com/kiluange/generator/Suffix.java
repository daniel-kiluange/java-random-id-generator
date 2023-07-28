package com.kiluange.generator;

class Suffix implements Component {

    private String suffix;
    private Component component;

    public Suffix(String suffix, Component component) {
        this.suffix = suffix;
        this.component = component;
    }

    @Override
    public String generate() {
        String pattern = "%s%s";
        return String.format(pattern, component.generate(), suffix);
    }
}
