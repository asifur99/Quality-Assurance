package Assignment2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TestSuite is a test suite fore all tests. All testcase files should be inside the Suite
 *
 * @author Sebastian Gadzinski
 */

@RunWith(Suite.class)
@Suite.SuiteClasses( {
        ParamTest1.class,
        ParamTest2.class,
        ParamTest3.class,
        ParamTest4.class,
        ParamTest5.class,
        ParamTest6.class,
        ParamTest7.class,
        ParamTest8.class,
        ParamTest9.class,
        ParamTest10.class,
} )
public class TestSuite {}