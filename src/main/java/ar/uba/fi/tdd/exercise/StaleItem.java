package ar.uba.fi.tdd.exercise;

public class StaleItem implements Qualifiable {
    private static final int MAX_QUALITY = 50;
    private static final int SELL_IN_DATE = 0;
    private static final int MIN_QUALITY = 0;
    protected Item item;

    public StaleItem(Item item){
        if (item.quality > MAX_QUALITY || item.quality < MIN_QUALITY) {
            throw new IllegalArgumentException("Quality should be between"+ MIN_QUALITY +"and"+ MAX_QUALITY);
        }
        this.item = item;
    }

    @Override
    public void updateQuality() {
        this.upgradeQuality();
        if (item.sellIn < SELL_IN_DATE){
            this.upgradeQuality();
        }
    }

    private void upgradeQuality(){
        if (this.item.quality < MAX_QUALITY){
            this.item.quality++;
        }
    }

    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
