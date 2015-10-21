import dfa.*;

class FiniteAutomataApplication {
  public static void main(String[] argv) {
    DFAFactory factory = new DFAFactory();

    DFA automata = factory.testCreate();
    String[] testCases = factory.testGetTestCases();

    System.out.println("FiniteAutomata");
  }
}