package br.com.sam.tests.harrypotter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class HarryPotterPricingModelTest {

    private HarryPotterPricingModel pricingModel = new HarryPotterPricingModel();

    @Test
    public void oneBookTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        assertThat(pricingModel.calculateFor(books), is((double) 8));
    }

    @Test
    public void twoDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        assertThat(pricingModel.calculateFor(books), is(15.2));
    }

    @Test
    public void threeDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        assertThat(pricingModel.calculateFor(books), is(21.6));
    }

    @Test
    public void fourDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        assertThat(pricingModel.calculateFor(books), is(25.6));
    }

    @Test
    public void fiveDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is((double) 30));
    }

    @Test
    public void twoEqualsBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        assertThat(pricingModel.calculateFor(books), is((double) 16));
    }

    @Test
    public void twoEqualsAndOneDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        assertThat(pricingModel.calculateFor(books), is(23.2));
    }

    @Test
    public void twoEqualsAndTwoDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        assertThat(pricingModel.calculateFor(books), is(30.4));
    }

    @Test
    public void noBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        assertThat(pricingModel.calculateFor(books), is(0.0));
    }

    @Test
    public void twoEqualsAndFiveDifferentBooksTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is(38.0));
    }

    @Test
    public void fourDifferentBooksTwiceTest() {
        List<HarryPotterBook> books = new ArrayList<>();
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.FIRST);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.SECOND);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.THIRD);
        books.add(HarryPotterBook.FOURTH);
        books.add(HarryPotterBook.FIFTH);
        assertThat(pricingModel.calculateFor(books), is(51.2));
    }

    @Test
    public void threeMaxDiscountAndTwoFourBooksDiscountTest() {
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
        assertThat(pricingModel.calculateFor(books), is(141.2));
    }


}
