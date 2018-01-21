package com.mytaxi.android_demo;

/**
 * Created by cthalayasingam on 19/01/2018.
 */
import android.app.ActionBar;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.matcher.ViewMatchers.*;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.*;
import android.support.test.filters.*;
import android.support.test.espresso.matcher.ViewMatchers;
import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class BasicTest {




    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void login() throws Exception {
        ApplicationMechanism.userLogin("whiteelephant261", "video");
        ApplicationMechanism.verifyName("whiteelephant261");
        ApplicationMechanism.searchDriver("sa", "Sarah Friedrich");
        ApplicationMechanism.callDriver();
    }



}

