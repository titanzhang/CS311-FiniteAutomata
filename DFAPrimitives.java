package dfa;
import java.util.*;

class FAState { // TODO
  private int number = 0;

  public FAState(int number) {
    this.number = number;
  }
}

class FAAlphabet { // TODO
  private char alphabet = '';

  public FAAlphabet(char alphabet) {
    this.alphabet = alphabet;
  }
}

class FAStateSet { // TODO
  public boolean contains(FAState faState) {
    return true;
  } 
}

class FATransitTable { // TODO
  private Map<FARuleKey, FAState> table = new HashMap<FARuleKey, FAState>();

  public boolean add(FARuleKey key, FAState value) {
    return this.table.add(key, value);
  }

  public FAState getNextState(FAState state, FAAlphabet alphabet) { // TODO
    return null
  }

  public static class FARuleKey { // TODO
    FAState state = null;
    FAAlphabet input = null;

    public FARuleKey(FAState state, FAAlphabet input) {
      this.state = state;
      this.input = input;
    }

    public static FARuleKey create(FAState state, FAAlphabet input) {
      return new FARuleKey(state, input);
    }
  }
}