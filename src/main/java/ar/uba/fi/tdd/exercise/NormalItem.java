package ar.uba.fi.tdd.exercise;

public class NormalItem implements Qualifiable {
    protected Item item;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int SELL_IN_DATE = 0;

    public NormalItem(Item item){
        if (item.quality > MAX_QUALITY || item.quality < MIN_QUALITY) {
            throw new IllegalArgumentException("Quality should be between"+ MIN_QUALITY +"and"+ MAX_QUALITY);
        }
        this.item = item;
    }

    @Override
    public void updateQuality() {
        degradeQuality();
        if (this.item.sellIn < SELL_IN_DATE){
            degradeQuality();
        }
    }

    private void degradeQuality(){
        if (this.item.quality > MIN_QUALITY){
            this.item.quality--;
        }
    }

    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
