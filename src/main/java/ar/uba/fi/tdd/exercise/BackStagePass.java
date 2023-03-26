package ar.uba.fi.tdd.exercise;

public class BackStagePass extends StaleItem{
    private static final int MIN_QUALITY = 0;
    private static final int SELL_IN_DATE = 0;


    public BackStagePass(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {

    }

}
