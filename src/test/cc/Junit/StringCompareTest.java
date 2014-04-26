package test.cc.Junit;

import java.util.*;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import cc.JunitTest.StringCompare;

@RunWith(value=Parameterized.class)
public class StringCompareTest {

	private StringCompare strcat;
	
	@Parameterized.Parameters 
    public static Collection<String[]> getPlusParameters() {
        return Arrays.asList(
            new String[][] {
                {"aabb", "aa", "bb"},  //expected, para1, para2, expected2, para3, para4
                {"ccdd", "cc", "dd"},
            }
        );
    }
    
    private String expected;
    private String para1;
    private String para2;

    public StringCompareTest(String expected, String para1, String para2) {
        this.expected = expected;
        this.para1 = para1;
        this.para2 = para2;
    }
    
    
    @Before
    public void setUp() {
    	strcat = new StringCompare();
    }
    
    @After
    public void tearDown() {
    	strcat = null;
    }

    @Test
    public void testStrCat() {
        String result = strcat.StrCat(para1, para2);
        assertEquals(expected, result);
    }

}
