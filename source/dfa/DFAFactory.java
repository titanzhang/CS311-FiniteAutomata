package dfa;
import java.util.*;

// Read DFA definition, test cases from file
// create the corresponding DFA
public class DFAFactory {
  private DFA dfa = null;
  private String[] testCases = null;

  public DFAFactory() {}

  public DFAFactory parseData(String dataFileName) { // TODO

    // test M1
    this.dfa = this.testCreate1();
    this.testCases = this.testGetTestCases1();

    return this;
  }

  public DFA getDFA() {
    return this.dfa;
  }

  public String[] getTestCases() {
    return this.testCases;
  }

  private DFA testCreate1() { // for test M1
    // Alphabets
    // input format: {0,1}
    List<FAAlphabet> alphabetList = new ArrayList<FAAlphabet>();
    //alphabetList.add(new FAAlphabet(new char[]{'0','2'}));
    alphabetList.add(new FAAlphabet('0'));
    alphabetList.add(new FAAlphabet('1'));

    // States
    // intput format: {0,1,2}
    List<FAState> stateList = new ArrayList<FAState>();
    stateList.add(new FAState(0));
    stateList.add(new FAState(1));

    // Init state
    // input format: 0
    FAState initState = new FAState(0);

    // Final states
    // input format: {stateIndex,...}
    // For this instance: {1}
    List<FAState> finalStates = new ArrayList<FAState>();
    finalStates.add(new FAState(1));

    // Transition table
    // input format: {(state,alphabetIndex,nextState),...}
    // For this instance: {(0,0,1),(0,1,2),(1,0,1),(1,1,2),(2,0,1),(2,1,2)}
    FATransitTable transitTable = new FATransitTable();
    transitTable.add(new FAState(0), alphabetList.get(0), new FAState(1));
    transitTable.add(new FAState(0), alphabetList.get(1), new FAState(0));
    transitTable.add(new FAState(1), alphabetList.get(0), new FAState(1));
    transitTable.add(new FAState(1), alphabetList.get(1), new FAState(0));

    // Construct the DFA
    DFA dfa = new DFA(alphabetList, stateList, initState, finalStates, transitTable);

    return dfa;
  }

  private String[] testGetTestCases1() { // for test M1
    String[] cases = {
      "",
      "100",
      "011",
      "10abc",
      "0",
      "1",
      "0101011",
      "11010",
      "0001",
      "1110"
    };

    return cases;
  }
}