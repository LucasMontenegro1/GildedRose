package ar.uba.fi.tdd.exercise;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
	public void SulfurasDoesNotDegrade(){
		Item item = new Item("Sulfuras",10,80);
		Sulfuras sulfuras = new Sulfuras(item);
		sulfuras.updateQuality();
		sulfuras.updateSellIn();
		assertThat(item.quality).isEqualTo(80);
		assertThat(item.sellIn).isEqualTo(10);
	}

	@Test
	public void AgedBrieHasMoreQuality(){
		Item item = new Item("Aged Brie", 20,20);
		AgedBrie brie = new AgedBrie(item);
		brie.updateSellIn();
		brie.updateQuality();
		assertThat(item.sellIn).isEqualTo(19);
		assertThat(item.quality).isEqualTo(21);
	}

	@Test
	public void BackStagePassOfTenDays(){
		Item item = new Item("Backstage Pass", 10,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(22);
	}

	@Test
	public void BackStagePassOfFiveDays(){
		Item item = new Item("Backstage Pass", 5,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(23);
	}

	@Test
	public void BackStageWhenDayBecomesZero(){
		Item item = new Item("Backstage Pass", 1,20);
		BackStagePass back = new BackStagePass(item);
		back.updateSellIn();
		back.updateQuality();
		assertThat(item.quality).isEqualTo(0);
	}

	@Test
	public void makerCreatesAnAgedBrieCorrectly(){
		Item item = new Item("Aged Brie", 1,20);
		ItemMaker maker = new ItemMaker();
		Qualifiable brie = maker.makeItem(item);
		Assertions.assertTrue(brie instanceof AgedBrie);
	}


}
