package com.kiluange.generator;

import java.util.Random;

class Generator implements Component {

    private int length;
    private boolean isAlphanumeric;
    private final Component component;

    private final Random random = new Random();

    public Generator(Component component) {
        this.component = component;
    }

    public Generator isAlphanumeric(boolean isAlphanumeric){
        this.isAlphanumeric = isAlphanumeric;
        return this;
    }

    public Generator withLength(int length) {
        this.length = length;
        return this;
    }

    @Override
    public String generate() {

        String pattern = "%s%s";

        int[] charArr = new int[36];

        for (int i = 0; i < 10; i++) {
            charArr[i] = 48 + i;
        }

        for (int i = 10, j = 0; i < 36; i++, j++) {
            charArr[i] = 65 + j;
        }

        int leftLimit = isAlphanumeric ? 0 : 10;

        int rightLimit = charArr.length - 1;

        int limitLength = length;

        StringBuilder buffer = new StringBuilder(limitLength);

        for (int i = 0; i < limitLength; i++) {
            int arrIndex = random.nextInt(leftLimit, rightLimit);

            buffer.append((char) charArr[arrIndex]);
        }

        return String.format(pattern, component.generate(), buffer);
    }
}
