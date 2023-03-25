package ar.uba.fi.tdd.exercise;

public class ConjuredItem implements Qualifiable{
    Item item;

    private static final int DEGRADE_RATE = 2;
    private static final int SELL_IN_DATE = 0;
    private static final int MIN_QUALITY = 0;


    public ConjuredItem(Item item){
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
        int discount = 0;
        while(discount <= DEGRADE_RATE || this.item.quality > MIN_QUALITY){
            this.item.quality--;
            discount++;
        }
    }


    @Override
    public void updateSellIn() {

    }
}
