package test.java;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Solution;

public class SolutionTest {

    Solution solution;
    Thread thread;
    public SolutionTest(){}

    @Before
    public void setUp()
    {
    	solution = new Solution();
    	thread = new Thread(solution);    	
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void test1() throws InterruptedException
    {
        String input = "101";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(1, solution.getNumOfPartition());
    }

    @Test
    public void test2() throws InterruptedException
    {
        String input = "101101101";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(3, solution.getNumOfPartition());
    }

    @Test
    public void test3() throws InterruptedException
    {
        String input = "1111101";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(1, solution.getNumOfPartition());
    }

    @Test
    public void test4() throws InterruptedException{
        String input = "00000";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(-1, solution.getNumOfPartition());
    }

    @Test
    public void test5() throws InterruptedException{
        String input = "11111111111111111111111111111111111111111111111111";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(50, solution.getNumOfPartition());
    }

    @Test
    public void test6() throws InterruptedException{
        String input = "10110001101000101011110000101110110001010";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(-1, solution.getNumOfPartition());
    }

    @Test
    public void test7() throws InterruptedException{
        String input = "10110001101000101011110000101110110001011";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(2, solution.getNumOfPartition());
    }

    @Test
    public void test8() throws InterruptedException{
        String input = "111011100110101100101110111";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(5, solution.getNumOfPartition());
    }

    @Test
    public void test9() throws InterruptedException{
        String input = "001000";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(-1, solution.getNumOfPartition());
    }

    @Test
    public void test10() throws InterruptedException{
        String input = "000001";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(-1, solution.getNumOfPartition());
    }

    @Test
    public void test11() throws InterruptedException{
        String input = "110111110101111000011";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(3, solution.getNumOfPartition());
    }
    
    @Test
    public void test12() throws InterruptedException{
        String input = "10111001100010000011110111100010000011110111";
        solution.setInput(input);
        thread.start();
        Thread.sleep(100);
        assertEquals(-1, solution.getNumOfPartition());
    }

}
