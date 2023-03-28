package ar.uba.fi.tdd.exercise;

public abstract class LegendaryItem implements Qualifiable {
    protected Item item;
    private static final int QUALITY = 80;

    public LegendaryItem(Item item){
        if (item.quality != QUALITY) {
            throw new IllegalArgumentException("Quality should be " + QUALITY);
        }
        this.item = item;
    }
    //Doesn't do anything since is a legendary item
    @Override
    public void updateQuality() {}

    @Override
    public void updateSellIn() {}
}
