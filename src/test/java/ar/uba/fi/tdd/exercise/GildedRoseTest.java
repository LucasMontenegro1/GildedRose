package ar.uba.fi.tdd.exercise;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class GildedRoseTest {

	@Test
	public void unknownItemWorks() {
		Item[] items = new Item[] { new Item("Unknown", 1, 3) };
		GildedRose app = new GildedRose(items);
		app.updateQuality();

		Item item = app.items[0];
		assertThat(item.name).isEqualTo("Unknown");
		assertThat(item.sellIn).isEqualTo(0);
		assertThat(item.quality).isEqualTo(2);
	}

	@Test
	public void qualityCantBeLowerThanZero(){
		Item item = new Item("Sulfuras, Hand of Ragnaros",10,-1);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Sulfuras(item));
	}

	@Test
	public void legendaryItemsQualityShouldBe80(){
		Item item = new Item("Sulfuras, Hand of Ragnaros",10,79);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new Sulfuras(item));
	}

	@Test
	public void cantCreateNormalItemWithQualityOver50(){
		Item item = new Item("Unknown", 2,51);
		Assertions.assertThrows(IllegalArgumentException.class, ()-> new NormalItem(item));
	}

	@Test
	public void normalItemDegradesCorrectlyWhenSellInGreaterThanZero(){
		Item item = new Item("Unknown",2,2);
		Qualifiable normal = new NormalItem(item);
		normal.updateSellIn();
		normal.updateQuality();
		assertThat(item.quality).isEqualTo(1);
	}

	@Test
	public void normalItemDegradesTwiceAsFastAfterSellIn(){
		Item item = new Item("Unknown",0,2);
		Qualifiable normal = new NormalItem(item);
		normal.updateSellIn();
		normal.updateQuality();
		assertThat(item.quality).isEqualTo(0);
	}

	@Test
	void qualityOfAnItemIsNeverNegative(){
		Item item = new Item("Unknown",0,0);
		Qualifiable normal = new NormalItem(item);
		normal.updateSellIn();
		normal.updateQuality();
		assertThat(item.quality).isEqualTo(0);
	}

	@Test
	public void agedBrieHasMoreQuality(){
		Item item = new Item("Aged Brie", 20,20);
		AgedBrie brie = new AgedBrie(item);
		brie.updateSellIn();
		brie.updateQuality();
		assertThat(item.quality).isEqualTo(21);
	}

	@Test
	public void agedBrieHasLessSellIn(){
		Item item = new Item("Aged Brie", 20,20);
		AgedBrie brie = new AgedBrie(item);
		brie.updateSellIn();
		brie.updateQuality();
		assertThat(item.sellIn).isEqualTo(19);
	}

	@Test
	public void agedBrieUpgradesCorrectlyTillMax(){
		Item item = new Item("Aged Brie", 2,50);
		ItemMaker maker = new ItemMaker();
		Qualifiable brie = maker.makeItem(item);
		brie.updateSellIn();
		brie.updateQuality();
		assertThat(item.quality).isEqualTo(50);
	}

	@Test
	public void agedBrieUpgradesCorrectlyAfterSellIn(){
		Item item = new Item("Aged Brie", 0,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable brie = maker.makeItem(item);
		brie.updateSellIn();
		brie.updateQuality();
		assertThat(item.quality).isEqualTo(22);
	}


	@Test
	public void sulfurasDoesNotDegrade(){
		Item item = new Item("Sulfuras",10,80);
		Sulfuras sulfuras = new Sulfuras(item);
		sulfuras.updateSellIn();
		sulfuras.updateQuality();
		assertThat(item.quality).isEqualTo(80);

	}

	@Test
	public void sulfurasDoesNotHaveToBeSold(){
		Item item = new Item("Sulfuras",10,80);
		Sulfuras sulfuras = new Sulfuras(item);
		sulfuras.updateSellIn();
		assertThat(item.sellIn).isEqualTo(10);
	}
	@Test
	public void backStagePassOfTenDays(){
		Item item = new Item("Backstage Pass", 10,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(22);
	}

	@Test
	public void backStagePassOfFiveDays(){
		Item item = new Item("Backstage Pass", 5,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(23);
	}

	@Test
	public void backStageWhenDayBecomesZero(){
		Item item = new Item("Backstage Pass", 1,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(0);
	}

	@Test
	public void backStageOverTen(){
		Item item = new Item("Backstage Pass", 12,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(21);
	}
	@Test
	public void makerCreatesAnAgedBrieCorrectly(){
		Item item = new Item("Aged Brie", 1,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable brie = maker.makeItem(item);
		Assertions.assertTrue(brie instanceof AgedBrie);
	}

	@Test
	public void makerCreatesSulfurasCorrectly(){
		Item item = new Item("Sulfuras, Hand of Ragnaros", 1,80);
		ItemMaker maker = new ItemMaker();
		Qualifiable sulf = maker.makeItem(item);
		Assertions.assertTrue(sulf instanceof Sulfuras);
	}

	@Test
	public void makerCreatesBackStagePassCorrectly(){
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable back = maker.makeItem(item);
		Assertions.assertTrue(back instanceof BackStagePass);
	}

	@Test
	public void makerCreatesConjuredManaCakeCorrectly(){
		Item item = new Item("Conjured Mana Cake", 1,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable conj = maker.makeItem(item);
		Assertions.assertTrue(conj instanceof ConjuredItem);
	}

	@Test
	public void makerCreatesANormalItemCorrectly(){
		Item item = new Item("name", 1,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable normal = maker.makeItem(item);
		Assertions.assertTrue(normal instanceof NormalItem);
	}

	@Test
	public void conjuredItemDegradesTwiceAsFastNormally(){
		Item item = new Item("Conjured Mana Cake", 2,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable cake = maker.makeItem(item);
		cake.updateSellIn();
		cake.updateQuality();
		assertThat(item.quality).isEqualTo(18);
	}

	@Test
	public void conjuredItemDegradesTwiceAsFastAfterZero(){
		Item item = new Item("Conjured Mana Cake", 0,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable cake = maker.makeItem(item);
		cake.updateSellIn();
		cake.updateQuality();
		assertThat(item.quality).isEqualTo(16);
	}


}
