package dfa;

public class FAState extends Object{ // TODO
  private int number = 0;

  public FAState(int number) {
    this.number = number;
  }

  @Override
  public int hashCode() {
    int result = 17;

    result = 31 * result + this.number;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;

    return (this.hashCode() == obj.hashCode());
  }

  public int getState() {
    return this.number;
  }
}