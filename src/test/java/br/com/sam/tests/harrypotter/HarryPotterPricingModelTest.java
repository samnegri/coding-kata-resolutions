package br.com.sam.tests.harrypotter;

import br.com.sam.tests.harrypotter.HarryPotterBook;
import br.com.sam.tests.harrypotter.HarryPotterPricingModel;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class HarryPotterPricingModelTest {

    @Test
    public void oneBookTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(8)));
    }

    @Test
    public void twoDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(15.2)));
    }

    @Test
    public void threeDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(21.6)));
    }

    @Test
    public void fourDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(25.6)));
    }

    @Test
    public void fiveDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(30)));
    }

    @Test
    public void twoEqualsBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(16)));
    }

    @Test
    public void twoEqualsAndOneDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(23.2)));
    }

    @Test
    public void twoEqualsAndTwoDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(30.4)));
    }

    @Test
    public void noBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(0.0)));
    }

    @Test
    public void twoEqualsAndFiveDifferentBooksTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(38.0)));
    }

    @Test
    public void fourDifferentBooksTwiceTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(51.2)));
    }

    @Test
    public void afourDifferentBooksTwiceTest() {
        HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        books.add(HarryPotterBook.FIFTH);
        books.add(HarryPotterBook.FIFTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is(toBigDecimalWithScale(141.2)));
    }


    private BigDecimal toBigDecimalWithScale(double val) {
        return new BigDecimal(val).setScale(2, RoundingMode.HALF_EVEN);
    }
}
