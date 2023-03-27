package ar.uba.fi.tdd.exercise;

public class StaleItem implements Qualifiable {
    private static final int MAX_QUALITY = 50;
    private static final int SELL_IN_DATE = 0;
    protected Item item;

    public StaleItem(Item item){
        if (item.quality > MAX_QUALITY) {
            throw new IllegalArgumentException("Quality cannot be greater than " + MAX_QUALITY);
        }
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (this.item.quality < MAX_QUALITY){
            this.item.quality++;
        }
    }

    @Override
    public void updateSellIn() {
        if (this.item.sellIn > SELL_IN_DATE){
            this.item.sellIn--;
        }
    }
}
