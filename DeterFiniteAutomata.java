package dfa;

class DFA {
  private int inputIndex = -1;
  private String input = null;

  //  Properties of an FA
  private FAState initState = null;
  private FAStateSet finalStates = null;
  private FATransitTable transitTable = null;
  // TODO: Do we need a property for alphabet set?
  // TODO: Do we need a property for all states?

  public DFA(FAState initState, FAStateSet finalStates, FATransitTable transitTable) {
    this.states = states;
    this.initState = initState;
    this.finalStates = finalStates;
    this.transitTable = transitTable;
  }

  public boolean isAccept(String input) {
    this.initStatus(input);

    FAState currentState = this.initState;
    FAAlphabet symbol;

    while ((symbol = this.getNextSymbol()) != null) {
      currentState = this.getNextState(currentState, symbol);
      if (currentState == null) { // In case of no trap state, goes here
        break;
      }
    }

    if (this.isInputComplete() && this.finalStates.contains(currentState)) {
      return true;
    }

    return false;
  }

  protected FAState getNextState(FAState currentState, FAAlphabet symbol) { // TODO: Find the next state from transition table
    return null;
  }

  protected boolean isInputComplete() { // TODO: finish going through the whole input string?
    return true;
  }

  protected FAAlphabet getNextSymbol() { // TODO: get the next char in input string
    return null;
  }

  protected void initStatus(String input) {
    this.inputIndex = -1;
    this.input = input;
  }
}
