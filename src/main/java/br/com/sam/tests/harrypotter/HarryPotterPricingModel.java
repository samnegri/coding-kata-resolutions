package br.com.sam.tests.harrypotter;

import br.com.sam.tests.harrypotter.HarryPotterBook;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class HarryPotterPricingModel {

    public BigDecimal calculateFor(List<HarryPotterBook> books) {
        List<List<HarryPotterBook>> qttByBook = new ArrayList<>();
        for (HarryPotterBook book : books) {
            boolean added = false;
            int i = 0;
            while (!added && i < qttByBook.size()) {
                added = addIfNotExists(book, qttByBook.get(i));
                i++;
            }

            if(i==qttByBook.size() && !added){
                qttByBook.add(createNewList(book));
            }
        }

        double value = 0;
        List<HarryPotterBook> fullList = null;
        List<HarryPotterBook> singleBookList = null;
        for (List<HarryPotterBook> harryPotterBooks : qttByBook) {
            if(harryPotterBooks.size() == HarryPotterBook.values().length) {
                fullList = harryPotterBooks;
            }
            if(harryPotterBooks.size() == 3) {
                singleBookList = harryPotterBooks;
            }
        }

        if(fullList != null && singleBookList != null) {
            changeBookToSingleList(fullList, singleBookList);
        }

        for(List<HarryPotterBook> list : qttByBook) {
            value += list.size() * 8 * getDiscount(list.size());
        }

        return new BigDecimal(value).setScale(2, RoundingMode.HALF_EVEN);
    }

    private void changeBookToSingleList(List<HarryPotterBook> fullList, List<HarryPotterBook> singleBookList) {
        for (HarryPotterBook harryPotterBook : fullList) {
            if(!singleBookList.contains(harryPotterBook)) {
                fullList.remove(harryPotterBook);
                singleBookList.add(harryPotterBook);
                return;
            }
        }
    }

    private Double getDiscount(int qtdDifferentBooks) {
        Double discount = 0.0;
        switch (qtdDifferentBooks) {
            case 1 : discount = 1.0; break;
            case 2 : discount = 0.95; break;
            case 3 : discount = 0.90; break;
            case 4 : discount = 0.80; break;
            case 5 : discount = 0.75; break;
        }
        return discount;
    }

    private List<HarryPotterBook> createNewList(HarryPotterBook book) {
        List<HarryPotterBook> newList = new ArrayList<>();
        newList.add(book);
        return newList;
    }

    private boolean addIfNotExists(HarryPotterBook book, List<HarryPotterBook> harryPotterBooks) {
        if (harryPotterBooks.contains(book)) {
            return false;
        }

        harryPotterBooks.add(book);

        return true;
    }
}
