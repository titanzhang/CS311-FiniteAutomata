import dfa.*;
import java.util.*;

class FiniteAutomataApplication {
  public static void main(String[] argv) {
    if (argv.length < 1) {
      System.out.println("Please specify the data file.");
      return;
    }
    String dataFileName = argv[0];

    DFAFactory factory = new DFAFactory();
    factory.parseData(dataFileName);

    DFA automata = factory.getDFA();

    System.out.println("FA Definition:");
    System.out.println(automata.getDefinitionString());

    System.out.println("Test Cases:");
    Iterator<String> testCases = factory.getTestCases().iterator();
    while (testCases.hasNext()) {
      String input = testCases.next();
      System.out.printf(" \"%s\" --> %s\n", input, automata.isAccept(input)? "accept": "reject");
    }

  }
}