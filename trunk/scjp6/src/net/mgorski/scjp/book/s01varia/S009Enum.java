package net.mgorski.scjp.book.s01varia;

/* don't have to be public*/enum S009Enum {

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

class Sth {
    public enum Suits {
        CLUBS(20), DIAMONDS(20), HEARTS(30), SPADES(30), NOTRUMP(40) {
            public int getValue(int bid) {
                return ((bid - 1) * 30) + 40;
            }
        };
        Suits(int points) {
            this.points = points;
        }

        private int points;

        public int getValue(int bid) {
            return points * bid;
        }
    }

    public static void main(String[] args) {
        System.out.println(Suits.CLUBS.points);
    }
}
