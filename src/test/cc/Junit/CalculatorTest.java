package test.cc.Junit;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runner.notification.Failure;
import org.junit.runners.*;
import cc.JunitTest.Calculator;

@RunWith(value=Parameterized.class)
public class CalculatorTest {

	private Calculator calculator;
	
    @Parameterized.Parameters 
    public static Collection<Integer[]> getPlusParameters() {
        return Arrays.asList(
            new Integer[][] {
                {5, 3, 2, 1, 1, 1},  //expected, para1, para2, expected2, para3, para4
                {3, 1, 2, 6, 3, 2},
                {2, 1, 1, 8, 2, 4}
            }
        );
    }
    
    private int expected;
    private int para1;
    private int para2;
    private int expected2;
    private int para3;
    private int para4;
    
    public CalculatorTest(int expected, int para1, int para2, int expected2, int para3, int para4) {
        this.expected = expected;
        this.expected2 = expected2;
        this.para1 = para1;
        this.para2 = para2;
        this.para3 = para3;
        this.para4 = para4;
    }
    
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    
    @After
    public void tearDown() {
        calculator = null;
    }
    
    @Test
    public void testPlus() {
        int result = calculator.plus(para1, para2);
        assertEquals(expected+1, result);
    }
    
    @Test
    public void testTime() {
        int result = calculator.times(para3, para4);
        assertEquals(expected2, result);
    }
    
    public void ReturnFailure() {
        Result result = JUnitCore.runClasses(CalculatorTest.class);
        for(Failure failure : result.getFailures()) {
             System.out.print(failure.getTestHeader() +
                    "¡G " + failure.getMessage());
        }
    }
}