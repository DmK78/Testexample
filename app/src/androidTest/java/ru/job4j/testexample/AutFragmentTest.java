package ru.job4j.testexample;

import android.content.Intent;

import androidx.test.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class AutFragmentTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void yourSetUPFragment() {
        activityTestRule.getActivity()
                .getFragmentManager().beginTransaction();
    }

    @Test
    public void isFragmentVisible(){
        onView(withId(R.id.frameContainer)).check(matches(isDisplayed()));
    }



    @Test
    public void checkLabelText(){
        onView(withId(R.id.textViewStatus)).check(matches(withText("...")));
    }

    @Test
    public void checkButtonSendIsClickable(){
        onView(withId(R.id.buttonSend)).check(matches(isClickable()));
    }

    @Test
    public void checkLabelWithError(){
        onView(withId(R.id.buttonSend)).perform(click());
        onView(withId(R.id.textViewStatus)).check(matches(withText("Validation Error!")));
    }

    @Test
    public void checkLabelWithOk(){
        onView(withId(R.id.editTextEmail)).perform(replaceText("dmk78@inbox.ru"));
        onView(withId(R.id.buttonSend)).perform(click());
        onView(withId(R.id.textViewStatus)).check(matches(withText("Success!")));
    }


}