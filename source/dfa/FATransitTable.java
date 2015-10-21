package dfa;
import java.util.*;

public class FATransitTable extends Object { // TODO
  private Map<FARuleKey, FAState> table = new HashMap<FARuleKey, FAState>();

  public void add(FARuleKey key, FAState value) {
    this.table.put(key, value);
  }

  public FAState getNextState(FAState state, FAAlphabet alphabet) { // TODO
    return null;
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