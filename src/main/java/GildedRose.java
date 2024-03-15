class AgedBrieItem extends GildedRoseItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    public void calcQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }
    }

}
class BackstagePassesItem extends GildedRoseItem {
    private Item item;

    public BackstagePassesItem(Item item) {
        super(item);
    }

    @Override
    public void calcQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality += 1;
                }
            }
            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality += 1;
                }
            }
        }
        if (item.sellIn < 1) {
            item.quality = 0;
        }
    }
}
class SulfurasItem extends GildedRoseItem {
    private Item item;

    public SulfurasItem(Item item) {
        super(item);
    }

    @Override
    public void calcQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        if (item.sellIn < 1) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }
    }
}
class NormalItem  extends GildedRoseItem{
    private Item item;

    public NormalItem(Item item) {
        super(item);
    }

    @Override
    public void calcQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
        if (item.sellIn < 1) {
            if (item.quality > 0)
                item.quality -= 1;
        }
    }
}


class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        GildedRoseItem GildedRoseItem;
        for (Item item : items) {
            if (item.name.equals("Aged Brie")) {
                GildedRoseItem = new AgedBrieItem(item);
                GildedRoseItem.calcQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                GildedRoseItem = new BackstagePassesItem(item);
                GildedRoseItem.calcQuality(item);
            } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                GildedRoseItem = new SulfurasItem(item);
                GildedRoseItem.calcQuality(item);
            } else {
                GildedRoseItem = new NormalItem(item);
                GildedRoseItem.calcQuality(item);
            }

            calcSellin(item);
        }
    }

    private void calcSellin(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn -= 1;
        }
    }
}