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

}
