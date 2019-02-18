package com.example.android;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    public ActivityTestRule<next> secondActivityTestRule = new ActivityTestRule<next>(next.class);

    private MainActivity mActivity = null;
    private next secondActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(next.class.getName(), null, false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
        secondActivity = secondActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.tvSplash);

        assertNotNull(view);
    }

    @Test
    public void textLaunchOfSecondActivity() {
        SplashActivity activity = Robolectric.buildActivity(SplashActivity.class).create().start().resume().get();
        assertNotNull("MainActivity is not instantiated", activity);

        synchronized (this) {
            try {
                this.wait(3200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        assertNotNull(expectedIntent);

        assertEquals(expectedIntent, shadowOf(activity).getNextStartedActivity());
    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
        secondActivity = null;
    }
}