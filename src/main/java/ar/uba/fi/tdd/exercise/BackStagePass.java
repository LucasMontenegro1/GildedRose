package ar.uba.fi.tdd.exercise;

public class BackStagePass extends StaleItem{
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;
    private static final int SELL_IN_DATE = 0;
    private static final int SELL_FIRST_LIMIT = 10;
    private static final int SELL_SECOND_LIMIT = 5;


    public BackStagePass(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.sellIn == SELL_IN_DATE) {
            item.quality = MIN_QUALITY;
        } else{
            upgradeQuality();
            if (item.sellIn < SELL_FIRST_LIMIT){
                upgradeQuality();
                if (item.sellIn < SELL_SECOND_LIMIT){
                    upgradeQuality();
                }
            }
        }
    }

    private void upgradeQuality(){
        if (this.item.quality < MAX_QUALITY){
            this.item.quality++;
        }
    }
}
