package ar.uba.fi.tdd.exercise;

public class BackStagePass extends StaleItem{
    private static final int MIN_QUALITY = 0;
    private static final int SELL_IN_DATE = 0;
    private static final int MAX_QUALITY =50;
    private static final int SELL_FIRST = 10;
    private static final int SELL_SECOND = 5;
    private static final int FIRST_UPDATE = 1;
    private static final int SECOND_UPDATE = 2;
    private static final int THIRD_UPDATE = 3;

    public BackStagePass(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.sellIn <= SELL_IN_DATE){
            item.quality = MIN_QUALITY;
        } else{
            this.upgradeQuality();
        }
    }

    private void upgradeQuality() {
        int amount = 0;
        while(amount < this.selectState() && this.item.quality <MAX_QUALITY){
            item.quality++;
            amount++;
        }
    }

    private int selectState() {
        if (item.sellIn>SELL_FIRST){
            return FIRST_UPDATE;
        }else if(item.sellIn>SELL_SECOND){
            return SECOND_UPDATE;
        }else{
            return THIRD_UPDATE;
        }

    }
}
