package com.example.android;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class nextTest {

    @Rule
    public ActivityTestRule<next> i=new ActivityTestRule<next>(next.class);
    private next n=null;
    @Before
    public void setUp() throws Exception {
        n=i.getActivity();

    }
    @Test
    public void Testnext(){
        assertNotNull(n.findViewById(R.id.tvnext));
    }

    @After
    public void tearDown() throws Exception {
        n=null;
    }
}