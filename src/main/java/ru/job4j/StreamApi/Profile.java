package ru.job4j.StreamApi;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    List<Address> collect(List<Profile> profiles){
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return getAddress().equals(profile.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }
}
