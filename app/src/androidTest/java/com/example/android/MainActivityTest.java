package com.example.android;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.app.AppCompatActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.TestCase.assertNotNull;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule=
            new ActivityTestRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity=null;
    Instrumentation.ActivityMonitor activityMonitor=
            getInstrumentation().addMonitor(next.class.getName(),null,false);


    @Before
    public void setUp() throws Exception {
        mActivity=mActivityTestRule.getActivity();

    }
    @Test
    public  void Test()
    {
       Activity nextactivity=
               getInstrumentation().waitForMonitorWithTimeout(activityMonitor,4000);
       assertNotNull(nextactivity);
    }



    @After
    public void tearDown() throws Exception {
        mActivity=null;

    }


}