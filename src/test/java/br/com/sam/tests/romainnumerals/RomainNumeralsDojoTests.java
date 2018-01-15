package br.com.sam.tests.romainnumerals;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Samuel Negri Morais on 1/14/18.
 */
public class RomainNumeralsDojoTests {

    private RomainNumeralsTranslator translator = new RomainNumeralsTranslator();

    @Test
    public void mainNumeralsTest() {
        assertThat(translator.toRomain(1), is("I"));
        assertThat(translator.toRomain(5), is("V"));
        assertThat(translator.toRomain(10), is("X"));
        assertThat(translator.toRomain(50), is("L"));
        assertThat(translator.toRomain(100), is("C"));
        assertThat(translator.toRomain(500), is("D"));
        assertThat(translator.toRomain(1000), is("M"));
    }

    @Test
    public void repeatingNumeralsTest() {
        assertThat(translator.toRomain(2), is("II"));
        assertThat(translator.toRomain(8), is("VIII"));
        assertThat(translator.toRomain(17), is("XVII"));
        assertThat(translator.toRomain(67), is("LXVII"));
        assertThat(translator.toRomain(167), is("CLXVII"));
        assertThat(translator.toRomain(767), is("DCCLXVII"));
        assertThat(translator.toRomain(1767), is("MDCCLXVII"));
    }

    @Test
    public void dontRepeatWhenAboutToChangeNumeralTest() {
        assertThat(translator.toRomain(4), is("IV"));
        assertThat(translator.toRomain(9), is("IX"));
        assertThat(translator.toRomain(40), is("XL"));
        assertThat(translator.toRomain(90), is("XC"));
        assertThat(translator.toRomain(400), is("CD"));
        assertThat(translator.toRomain(900), is("CM"));
    }
}
