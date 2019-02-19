package com.example.android;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class WalkthroughTest {
    @Rule
    public ActivityTestRule<Walkthrough> ActivityTestRule = new ActivityTestRule<Walkthrough>(Walkthrough.class);

    public Walkthrough mActivity = null;


    @Before
    public void setUp() throws Exception {
        mActivity = ActivityTestRule.getActivity();

    }
    @Test
    public void testlaunch(){

        View view = mActivity.findViewById(R.id.dotsLayout);
        View view3 = mActivity.findViewById(R.id.slide_view_pager);

        assertNotNull(view);
        assertNotNull(view3);
    }

    @Test
    public void CheckbuttonClick(){

        Espresso.onView(withId(R.id.skip_button)).perform(click());

    }

    @Test
    public void CheckSwipingAction(){

        Espresso.onView(ViewMatchers.withId(R.id.slide_view_pager)).perform(swipeRight());
        Espresso.onView(ViewMatchers.withId(R.id.slide_view_pager)).perform(swipeRight());


        Espresso.onView(ViewMatchers.withId(R.id.slide_view_pager)).perform(swipeLeft());
        Espresso.onView(ViewMatchers.withId(R.id.slide_view_pager)).perform(swipeLeft());



    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

}