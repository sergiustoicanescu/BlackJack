package Domain;

public enum PlayingCardValue {
    Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7),
    Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10), Ace(11);
    private int value;

    PlayingCardValue(int i) {
        this.value = i;
    }
    public int getValue() {
        return value;
    }
}
