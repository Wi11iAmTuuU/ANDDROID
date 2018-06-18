package com.example.williamtuuu.hw4_2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        RockPaperScissors mH = new RockPaperScissors();
        // 0 – 剪刀, 1 – 石頭, 2 – 布.
        String result = mH.getresult(0,0);
        assertEquals(result,"draw");

        result = mH.getresult(0,1);
        assertEquals(result,"lose");

        result = mH.getresult(0,2);
        assertEquals(result,"win");

        result = mH.getresult(1,0);
        assertEquals(result,"win");

        result = mH.getresult(1,1);
        assertEquals(result,"draw");

        result = mH.getresult(1,2);
        assertEquals(result,"lose");

        result = mH.getresult(2,0);
        assertEquals(result,"lose");

        result = mH.getresult(2,1);
        assertEquals(result,"win");

        result = mH.getresult(2,2);
        assertEquals(result,"draw");
    }
}