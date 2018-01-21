package com.mytaxi.android_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onIdle;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mytaxi.android_demo.activities.MainActivityTest.childAtPosition;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
*/
public class ApplicationMechanism {


    public static void userLogin(String username, String password) throws Exception {
        ViewInteraction usernameBox = onView(ViewMatchers.withId(R.id.edt_username)).perform(click()).perform(typeText(username));
        ViewInteraction passwordBox = onView(ViewMatchers.withId(R.id.edt_password)).perform(click()).perform(typeText(password));
        ViewInteraction loginButton = onView(ViewMatchers.withId(R.id.btn_login)).perform(click());

    }

    public static void verifyName(String username) throws Exception {
        ViewInteraction userName = onView(ViewMatchers.withId(R.id.nav_username)).check(matches(ViewMatchers.withText(username)));
    }

    public static void logout() throws Exception {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        1),
                        isDisplayed()));
        navigationMenuItemView.perform(click());
    }

    public static void searchDriver(String searchText, String searchItem) throws Exception {

        ViewInteraction appCompatAutoCompleteTextView = onView(ViewMatchers.withId(R.id.textSearch)).perform(click()).perform(typeText("sarah"));
        appCompatAutoCompleteTextView.perform(replaceText(searchText), closeSoftKeyboard());
        DataInteraction appCompatTextView = onData(anything()).inAdapterView(withText(searchText));
        appCompatTextView.perform(click());

        ViewInteraction driverNameView = onView(ViewMatchers.withId(R.id.textViewDriverName));
        driverNameView.check(matches(withText(searchText)));
    }

    public static void callDriver() throws Exception {
        ViewInteraction floatingActionButton = onView(withId(R.id.fab));
        floatingActionButton.perform(click());
    }






}