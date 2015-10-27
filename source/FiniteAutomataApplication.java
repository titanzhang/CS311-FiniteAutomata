import dfa.*;

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
    String[] testCases = factory.getTestCases();

    System.out.println("FA Definition:");
    System.out.println(automata.getDefinitionString());
    System.out.println("Test Cases:");
    for (int i = 0; i < testCases.length; i ++) {
      String input = testCases[i];
      System.out.printf(" \"%s\" --> %s\n", input, automata.isAccept(input)? "accept": "reject");
    }

  }
}