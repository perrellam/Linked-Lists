package testcases;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Test suite constructed of all test cases in "testcases" source folder
 * @author Mason Perrella
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { 
	TestLinkedList.class
}
	)
public class AllTests {
	// class remains empty and serves as a place holder for above
}
