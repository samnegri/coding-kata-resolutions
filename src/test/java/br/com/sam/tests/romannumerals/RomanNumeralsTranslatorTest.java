package br.com.sam.tests.romannumerals;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
/*      Source: https://github.com/codingdojo-org/codingdojo.org/blob/master/content/kata/RomanNumerals.md
        Problem Description
        The Romans were a clever bunch. They conquered most of Europe and ruled it for hundreds of years.
        They invented concrete and straight roads and even bikinis [1]. One thing they never discovered
        though was the number zero. This made writing and dating extensive histories of their exploits
        slightly more challenging, but the system of numbers they came up with is still in use today. For
        example the BBC uses Roman numerals to date their programmes. The Romans wrote numbers using
        letters : I, V, X, L, C, D, M. (notice these letters have lots of straight lines and are hence
        easy to hack into stone tablets)
        Part I
        The Kata says you should write a function to convert from normal numbers to Roman Numerals: eg
             1 --> I
             10 --> X
             7 --> VII
        etc.
        There is no need to be able to convert numbers larger than about 3000. (The Romans themselves
        didn't tend to go any higher)
        Part II
        Write a function to convert in the other direction, ie numeral to digit */
public class RomanNumeralsTranslatorTest {

    private RomanNumeralsTranslator translator = new RomanNumeralsTranslator();

    @Test
    public void toRomanMainNumeralsTest() {
        assertThat(translator.toRoman(1), is("I"));
        assertThat(translator.toRoman(5), is("V"));
        assertThat(translator.toRoman(10), is("X"));
        assertThat(translator.toRoman(50), is("L"));
        assertThat(translator.toRoman(100), is("C"));
        assertThat(translator.toRoman(500), is("D"));
        assertThat(translator.toRoman(1000), is("M"));
    }

    @Test
    public void toRomanRepeatingNumeralsTest() {
        assertThat(translator.toRoman(2), is("II"));
        assertThat(translator.toRoman(8), is("VIII"));
        assertThat(translator.toRoman(17), is("XVII"));
        assertThat(translator.toRoman(67), is("LXVII"));
        assertThat(translator.toRoman(167), is("CLXVII"));
        assertThat(translator.toRoman(767), is("DCCLXVII"));
        assertThat(translator.toRoman(1767), is("MDCCLXVII"));
    }

    @Test
    public void toRomanDontRepeatWhenAboutToChangeNumeralTest() {
        assertThat(translator.toRoman(4), is("IV"));
        assertThat(translator.toRoman(9), is("IX"));
        assertThat(translator.toRoman(40), is("XL"));
        assertThat(translator.toRoman(90), is("XC"));
        assertThat(translator.toRoman(400), is("CD"));
        assertThat(translator.toRoman(900), is("CM"));
    }

    @Test
    public void toIntegerMainNumeralsTest() {
        assertThat(translator.toInteger("I"), is(1));
        assertThat(translator.toInteger("V"), is(5));
        assertThat(translator.toInteger("X"), is(10));
        assertThat(translator.toInteger("L"), is(50));
        assertThat(translator.toInteger("C"), is(100));
        assertThat(translator.toInteger("D"), is(500));
        assertThat(translator.toInteger("M"), is(1000));
    }
}
