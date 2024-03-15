public abstract class GildedRoseItem {
    protected Item item;

    public GildedRoseItem(Item item) {
        this.item = item;
    }

    public abstract void calcQuality(Item item);
}
