package net.mgorski.scjp.book.s01varia;

public enum S009Enum {

    BIG(10), SMALL(5) {
        @Override
        public String getCode() { // this overrides code for SMALL
            return "B";
        }
    };

    S009Enum(int size) {
        this.size = size;

    }

    private int size;

    public int getSize() {
        return size;
    }

    public String getCode() {
        return "A";
    }

}
