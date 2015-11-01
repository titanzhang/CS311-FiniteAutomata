package dfa;

public class FAState {
  private int number = 0;

  public FAState(int number) {
    this.number = number;
  }

  public int hashCode() {
    int result = 17;

    result = 31 * result + this.number;
    return result;
  }

  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;

    return (this.hashCode() == obj.hashCode());
  }

  public int getState() {
    return this.number;
  }
}