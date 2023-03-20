package ar.uba.fi.tdd.exercise;

public final class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String _name, int _sellIn, int _quality) {
        this.name = _name;
        this.sellIn = _sellIn;
        this.quality = _quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
