package ru.job4j.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void newProfilesShouldGiveAdresses() {
        Address firstAd = new Address("Moscow", "Pushkin", 122, 343);
        Address secondAd = new Address("Kazan", "Ra", 1, 3);
        Address thAd = new Address("Moscow", "Bulova", 12, 34);
        Address lastAd = new Address("Yamburg", "Bulova", 12, 34);
        Profile dan = new Profile(firstAd);
        Profile dik = new Profile(secondAd);
        Profile key = new Profile(thAd);
        Profile gam = new Profile(lastAd);
        List<Profile> list = new ArrayList<>();
        list.add(dan);
        list.add(dik);
        list.add(key);
        list.add(gam);
        List<Address> expectedList = new ArrayList<>();
        expectedList.add(secondAd);
        expectedList.add(firstAd);
        expectedList.add(lastAd);
        Profiles listNew = new Profiles();
        assertThat(expectedList, is(listNew.uniqueSort(list)));

    }

}