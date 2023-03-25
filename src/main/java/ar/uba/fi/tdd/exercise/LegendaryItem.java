package ar.uba.fi.tdd.exercise;

public abstract class LegendaryItem implements Qualifable,Sellable{
    protected Item item;
    private static final int MAX_QUALITY = 80;

    public LegendaryItem(Item item){
        this.item = item;
    }
    //Doesn't do anything since is a legendary item
    @Override
    public void updateQuality() {}

    @Override
    public void updateSellIn() {}
}
