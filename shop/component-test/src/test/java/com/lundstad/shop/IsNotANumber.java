package com.lundstad.shop;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsNotANumber extends TypeSafeMatcher {


    public void describeTo(Description description) {
        description.appendText("not a number");
    }

    public static Matcher notANumber() {
        return new IsNotANumber();
    }

    @Override
    protected boolean matchesSafely(Object item) {
        return false;
    }
}
