package com.kiluange.generator;

public class StringGenerator {

    private Component component;

    public StringGenerator(Component component) {
        this.component = component;
    }

    public String generateId(){
        return component.generate();
    }
}
