package dfa.parser;

import java.util.List;

import dfa.DFA;
import dfa.FAState;

public class FinalStatesParser extends StatesParser {
  public String getSectionName() {
    return "[finalStates]";
  }

  protected void setStates(List<FAState> states, DFA dfa) {
    dfa.setFinalStates(states);
  }
}
