
package ar.uba.fi.tdd.exercise;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] _items) {
        items = _items;
    }

    // update the quality of the emements
    public void updateQuality() {
        ItemMaker maker = new ItemMaker();
        for (Item i : items ){
            try {
                Qualifiable item = maker.makeItem(i);
                item.updateSellIn();
                item.updateQuality();
            } catch (Exception e){
                System.out.println(e);
            }

        }
    }



}
