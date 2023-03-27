package ar.uba.fi.tdd.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ItemMaker {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_ITEM = "Conjured Item";

    private static final Map<String, Function<Item, Qualifiable>> ITEM_TYPES = new HashMap<>();
    
    static {
        ITEM_TYPES.put(AGED_BRIE, AgedBrie::new);
        ITEM_TYPES.put(BACKSTAGE_PASSES, BackStagePass::new);
        ITEM_TYPES.put(SULFURAS, Sulfuras::new);
        ITEM_TYPES.put(CONJURED_ITEM, ConjuredItem::new);
    }

    public Qualifiable makeItem(Item item) {
        return ITEM_TYPES.getOrDefault(item.name, NormalItem::new).apply(item);
    }
}
