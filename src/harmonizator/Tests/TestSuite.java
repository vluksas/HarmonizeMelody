package harmonizator.Tests;

import harmonizator.Chord.Tests.ChordTestSuite;
import harmonizator.Rules.Tests.RuleTestSuite;
import harmonizator.Solver.Tests.SolverTestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
   SolverTestSuite.class,
   RuleTestSuite.class,
   ChordTestSuite.class,
   NoteTests.class,
   NoteFactoryTests.class
})
public class TestSuite {   
}
