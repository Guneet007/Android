package com.example.android;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowLooper;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

public class MainActivityTest extends Activity {

    @Rule
    public ActivityTestRule<MainActivity> mact = new ActivityTestRule<>(MainActivity.class);
    private MainActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getI

    @Before
    public void start(){
        mActivity=mact.getActivity();

    }

    @Test   //Tests Launching of activity after SplashScreen.
    public void testLaunch() {
        ActivityController<MainActivityTest> mainActivityTestActivityController;
        mainActivityTestActivityController = Robolectric.buildActivity(MainActivityTest.class);
        mainActivityTestActivityController.create();
        ActivityController<MainActivityTest> controller = mainActivityTestActivityController.start();
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();
            MainActivityTest splashScreenActivity = controller.get();
            Intent expectedIntent = new Intent(splashScreenActivity, next.class);

            assertEquals(expectedIntent,shadowOf(splashScreenActivity).getNextStartedActivity());
    }

}