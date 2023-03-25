package ar.uba.fi.tdd.exercise;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

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
	public void test01SulfurasDoesNotDegrade(){
		Item item = new Item("Sulfuras",10,80);
		Sulfuras sulfuras = new Sulfuras(item);
		sulfuras.updateQuality();
		sulfuras.updateSellIn();
		assertThat(item.quality).isEqualTo(80);
		assertThat(item.sellIn).isEqualTo(10);
	}

	@Test
	public void test02AgedBrieHasMoreQuality(){
		Item item = new Item("Aged Brie", 20,20);
		AgedBrie brie = new AgedBrie(item);
		brie.updateQuality();
		brie.updateSellIn();
		assertThat(item.sellIn).isEqualTo(19);
		assertThat(item.quality).isEqualTo(21);

	}

}
