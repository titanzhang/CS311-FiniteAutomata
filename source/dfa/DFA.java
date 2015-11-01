package dfa;
import java.util.*;

public class DFA {
  private int inputIndex = -1;
  private String input = null;

  //  Properties of an FA
  private List<FAAlphabet> alphabetList = null;
  private List<FAState> stateList = null;
  private FAState initState = null;
  private List<FAState> finalStates = null;
  private FATransitTable transitTable = null;

  public DFA() {
  }

  public boolean isAccept(String input) {
    this.initStatus(input);

    FAState currentState = this.initState;
    char symbol;

    while ((symbol = this.getNextSymbol()) != '\0') {
      currentState = this.getNextState(currentState, symbol);
      if (currentState == null) { // In case of no trap state, goes here
        break;
      }
    }

    if (this.isInputComplete() && this.isFinalState(currentState)) {
      return true;
    }

    return false;
  }

  protected FAState getNextState(FAState currentState, char symbol) {
    // Find an alphabet group containing the symbol
    FAAlphabet targetAlphabet = null;
    Iterator<FAAlphabet> iterator = this.alphabetList.iterator();
    while (iterator.hasNext()) {
      FAAlphabet alphabet = iterator.next();
      if (alphabet.contains(symbol)) {
        targetAlphabet = alphabet;
        break;
      }
    }

    if (targetAlphabet == null) {
      return null;
    }

    // Get the next state from transition table
    return this.transitTable.getNextState(currentState, targetAlphabet);
  }

  protected boolean isInputComplete() {
    return (this.inputIndex >= this.input.length());
  }

  protected boolean isFinalState(FAState state) {
    return this.finalStates.contains(state);
  }

  protected char getNextSymbol() {
    this.inputIndex ++;
    if (this.inputIndex >= this.input.length()) return '\0';

    return this.input.charAt(this.inputIndex);
  }

  protected void initStatus(String input) {
    this.inputIndex = -1;
    this.input = input;
  }

// Set/Get methods begin
  public DFA setAlphabetList(List<FAAlphabet> alphabetList) {
    this.alphabetList = alphabetList;
    return this;
  }

  public List<FAAlphabet> getAlphabetList() {
    return this.alphabetList;
  }

  public DFA setStateList(List<FAState> stateList) {
    this.stateList = stateList;
    return this;
  }

  public DFA setInitState(FAState initState) {
    this.initState = initState;
    return this;
  }

  public DFA setFinalStates(List<FAState> finalStates) {
    this.finalStates = finalStates;
    return this;
  }

  public DFA setTransitTable(FATransitTable transitTable) {
    this.transitTable = transitTable;
    return this;
  }
// Set/Get methods end

  public String getDefinitionString() {
    // Alphabet set
    String alphabetInfo = "AlphabetList = {\n";
    for (int i = 0; i < this.alphabetList.size(); i ++) {
      alphabetInfo += String.format("\t%d -> ", i);
      char[] alphabet = this.alphabetList.get(i).getAlphabet();
      for (int j = 0; j < alphabet.length; j ++) {
        alphabetInfo += String.format("%s%s", ((j==0)? "": ","), alphabet[j]);
      }
      alphabetInfo += "\n";
    }
    alphabetInfo += "}\n";

    // State set
    String stateSetInfo = "StateList = {";
    Iterator<FAState> stateIterator = this.stateList.iterator();
    while (stateIterator.hasNext()) {
      FAState state = stateIterator.next();
      stateSetInfo += String.format("%d,", state.getState());
    }
    stateSetInfo = stateSetInfo.substring(0, stateSetInfo.length() - 1) + "}\n";
    
    // Init state
    String initStateInfo = String.format("InitState = %d\n", this.initState.getState());

    // Final state set
    String finalStateInfo = "FinalStateList = {";
    stateIterator = this.finalStates.iterator();
    while (stateIterator.hasNext()) {
      FAState state = stateIterator.next();
      finalStateInfo += String.format("%d,", state.getState());
    }
    finalStateInfo = finalStateInfo.substring(0, finalStateInfo.length() - 1) + "}\n";

    // Transition table
    String transitTableInfo = "TransitionTable = {\n";
    Iterator<Map.Entry<FATransitTable.FARuleKey, FAState>> transitTableIt = this.transitTable.getTable().entrySet().iterator();
    while (transitTableIt.hasNext()) {
      Map.Entry<FATransitTable.FARuleKey, FAState> tableEntry = transitTableIt.next();
      FATransitTable.FARuleKey ruleKey = tableEntry.getKey();
      FAState state = tableEntry.getValue();
      FAAlphabet input = ruleKey.getInput();
      transitTableInfo += String.format("\t(%d, ", ruleKey.getState().getState());
      for (int i = 0; i < this.alphabetList.size(); i ++) {
        FAAlphabet alphabet = this.alphabetList.get(i);
        if (input.equals(alphabet)) {
          transitTableInfo += String.format("%d, ", i);
          break;
        }
      }
      transitTableInfo += String.format("%d)\n", state.getState());
    }
    transitTableInfo += "}\n";

    return alphabetInfo + stateSetInfo + initStateInfo + finalStateInfo + transitTableInfo;
  }
}
