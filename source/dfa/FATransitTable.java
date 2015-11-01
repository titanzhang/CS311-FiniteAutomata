package dfa;
import java.util.*;

public class FATransitTable extends Object {
  private Map<FARuleKey, FAState> table = new HashMap<FARuleKey, FAState>();

  public void add(FAState state, FAAlphabet alphabet, FAState nextState) {
    this.table.put(new FARuleKey(state, alphabet), nextState);
  }

  public FAState getNextState(FAState state, FAAlphabet alphabet) {
    return this.table.get(new FARuleKey(state, alphabet));
  }

  public Map<FARuleKey, FAState> getTable() {
    return this.table;
  }

  public static class FARuleKey {
    FAState state = null;
    FAAlphabet input = null;

    public FARuleKey(FAState state, FAAlphabet input) {
      this.state = state;
      this.input = input;
    }

    public FAState getState() {
      return this.state;
    }

    public FAAlphabet getInput() {
      return this.input;
    }

    public int hashCode() {
      int result = 17;
      result = (this.state == null)? 0: (31 * result + this.state.hashCode());
      result = (this.input == null)? 0: (31 * result + this.input.hashCode());
      return result;
    }

    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (obj == this) return true;

      return (this.hashCode() == obj.hashCode());
    }
  }
}