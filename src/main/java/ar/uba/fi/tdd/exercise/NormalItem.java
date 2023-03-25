package ar.uba.fi.tdd.exercise;

public class NormalItem implements Qualifable,Sellable{
    protected Item item;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;
    private static final int SELL_IN_DATE = 0;



    public NormalItem(Item item){
        this.item = item;
    }

    @Override
    public void updateQuality() {
        subtractQualityByOne();
        if (this.item.sellIn < SELL_IN_DATE){
            subtractQualityByOne();
        }
    }

    private void subtractQualityByOne(){
        if(this.item.quality > MIN_QUALITY){
            this.item.quality--;
        }
    }
    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
