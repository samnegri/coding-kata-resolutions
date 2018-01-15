package br.com.sam.tests.harrypotter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class HarryPotterPricingModel {

    public double calculateFor(List<HarryPotterBook> books) {
        List<List<HarryPotterBook>> qttByBook = fillBookLists(books);
        checkForBetterDiscount(qttByBook);
        return calculateTotalValue(qttByBook);
    }

    private double calculateTotalValue(List<List<HarryPotterBook>> qttByBook) {
        double value = 0;
        for (List<HarryPotterBook> list : qttByBook) {
            value += list.size() * 8 * getDiscount(list.size());
        }
        return value;
    }

    private void checkForBetterDiscount(List<List<HarryPotterBook>> qttByBook) {
        List<HarryPotterBook> fullList = null;
        List<HarryPotterBook> threeBooksList = null;
        for (List<HarryPotterBook> harryPotterBooks : qttByBook) {
            if (harryPotterBooks.size() == HarryPotterBook.values().length) {
                fullList = harryPotterBooks;
            }
            if (harryPotterBooks.size() == 3) {
                threeBooksList = harryPotterBooks;
            }
        }

        if (fullList != null && threeBooksList != null) {
            changeBookToSingleList(fullList, threeBooksList);
        }
    }

    private List<List<HarryPotterBook>> fillBookLists(List<HarryPotterBook> books) {
        List<List<HarryPotterBook>> qttByBook = new ArrayList<>();
        for (HarryPotterBook book : books) {
            boolean added = false;
            int i = 0;
            while (!added && i < qttByBook.size()) {
                added = addIfNotExists(book, qttByBook.get(i));
                i++;
            }

            if (i == qttByBook.size() && !added) {
                qttByBook.add(createNewList(book));
            }
        }
        return qttByBook;
    }

    private void changeBookToSingleList(List<HarryPotterBook> fullList, List<HarryPotterBook> threeBooksList) {
        for (HarryPotterBook harryPotterBook : fullList) {
            if (!threeBooksList.contains(harryPotterBook)) {
                fullList.remove(harryPotterBook);
                threeBooksList.add(harryPotterBook);
                return;
            }
        }
    }

    private Double getDiscount(int qtdDifferentBooks) {
        Double discount = 0.0;
        switch (qtdDifferentBooks) {
            case 1:
                discount = 1.0;
                break;
            case 2:
                discount = 0.95;
                break;
            case 3:
                discount = 0.90;
                break;
            case 4:
                discount = 0.80;
                break;
            case 5:
                discount = 0.75;
                break;
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
