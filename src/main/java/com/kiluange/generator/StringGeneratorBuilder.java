package com.kiluange.generator;

public interface StringGeneratorBuilder {

    class Builder {

        private String prefix = "";
        private String suffix = "";

        private int length = 8;
        private boolean isAlphanumeric = false;

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public Builder prefix(String prefix) {
            this.prefix = prefix;
            return this;
        }

        public Builder suffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        public Builder alphanumeric(boolean isAlphanumeric) {
            this.isAlphanumeric = isAlphanumeric;
            return this;
        }

        public StringGenerator create() {
            Prefix p = new Prefix(prefix);
            Generator g = new Generator(p)
                    .withLength(length)
                    .isAlphanumeric(isAlphanumeric);
            Suffix s = new Suffix(suffix, g);
            return new StringGenerator(s);
        }
    }
}
