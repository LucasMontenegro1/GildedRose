package ar.uba.fi.tdd.exercise;

public abstract class NormalItem implements Qualifable,Sellable{
    protected Item item;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int SELL_IN_DATE = 0;



    public NormalItem(Item item){
        this.item = item;
    }

    @Override
    public void updateQuality() {
        this.item.quality--;
        if (this.item.sellIn < SELL_IN_DATE){
            this.item.quality--;
        }
    }

    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
