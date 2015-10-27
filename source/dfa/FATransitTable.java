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

  public static class FARuleKey {
    FAState state = null;
    FAAlphabet input = null;

    public FARuleKey(FAState state, FAAlphabet input) {
      this.state = state;
      this.input = input;
    }

    @Override
    public int hashCode() {
      int result = 17;
      result = (this.state == null)? 0: (31 * result + this.state.hashCode());
      result = (this.input == null)? 0: (31 * result + this.input.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == null) return false;
      if (obj == this) return true;

      return (this.hashCode() == obj.hashCode());
    }
  }
}