package ar.uba.fi.tdd.exercise;

public class ItemMaker {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Item";

    public Qualifiable makeItem(Item item){
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackStagePass(item);
            case SULFURAS:
                return new Sulfuras(item);
            case CONJURED_ITEM:
                return new ConjuredItem(item);
            default:
                return new NormalItem(item);
        }
    }

}
