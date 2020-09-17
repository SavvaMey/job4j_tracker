package ru.job4j.StreamApi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void newProfilesShouldGiveAdresses(){
        Address firstAd = new Address("Moscow", "Pushkin", 122, 343);
        Address secondAd = new Address("Moscow", "Ra", 1, 3);
        Address thAd = new Address("Moscow", "Bulova", 12, 34);
        Profile dan = new Profile(firstAd);
        Profile dik = new Profile(secondAd);
        Profile key = new Profile(thAd);
        List<Profile> list = new ArrayList<>();
        list.add(dan);
        list.add(dik);
        list.add(key);
        List<Address> expectedList = new ArrayList<>();
        expectedList.add(firstAd);
        expectedList.add(secondAd);
        expectedList.add(thAd);
        Profiles listNew = new Profiles();
        assertThat(expectedList,is(listNew.collect(list)));

    }

}