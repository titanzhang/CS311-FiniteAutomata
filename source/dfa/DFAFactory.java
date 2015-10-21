package dfa;

// Read DFA definition, test cases from file
// create the corresponding DFA
public class DFAFactory {

  public DFAFactory() {}

  public DFA testCreate() { // for test
    FAState initState = new FAState(0);

    DFA dfa = new DFA(null, null, null);

    return dfa;
  }

  public String[] testGetTestCases() { // for test
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