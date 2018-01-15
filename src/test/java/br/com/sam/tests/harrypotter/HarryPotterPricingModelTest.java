package br.com.sam.tests.harrypotter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
/*      Source: https://github.com/codingdojo-org/codingdojo.org/blob/master/content/kata/Potter.md
        Problem Description:
        Once upon a time there was a series of 5 books about a very English hero called Harry.
        (At least when this Kata was invented, there were only 5. Since then they have multiplied)
        Children all over the world thought he was fantastic, and, of course, so did the publisher.
        So in a gesture of immense generosity to mankind, (and to increase sales) they set up the
        following pricing model to take advantage of Harry’s magical powers.
        One copy of any of the five books costs 8 EUR. If, however, you buy two different books from the series,
        you get a 5% discount on those two books. If you buy 3 different books, you get a 10% discount.
        With 4 different books, you get a 20% discount. If you go the whole hog, and buy all 5, you get
        a huge 25% discount. Note that if you buy, say, four books, of which 3 are different titles, you
         get a 10% discount on the 3 that form part of a set, but the fourth book still costs 8 EUR.
        Potter mania is sweeping the country and parents of teenagers everywhere are queueing up with
        shopping baskets overflowing with Potter books. Your mission is to write a piece of code to calculate
        the price of any conceivable shopping basket, giving as big a discount as possible.
        For example, how much does this basket of books cost?
        2 copies of the first book
        2 copies of the second book
        2 copies of the third book
        1 copy of the fourth book
        1 copy of the fifth book */
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
