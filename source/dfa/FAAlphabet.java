package dfa;

public class FAAlphabet extends Object {
  private char[] alphabet;

  public FAAlphabet(char alphabet) {
    this.alphabet = new char[1];
    this.alphabet[0] = alphabet;
  }

  public FAAlphabet(char[] alphabetGroup) {
    this.alphabet = alphabetGroup;
  }

  public boolean contains(char symbol) {
    for (int i = 0; i < this.alphabet.length; i ++) {
      if (this.alphabet[i] == symbol) return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;

    for (int i = 0; i < this.alphabet.length; i ++) {
      result = 31 * result + this.alphabet[i];
    }
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj == this) return true;

    return (this.hashCode() == obj.hashCode());
  }

  public char[] getAlphabet() {
    return this.alphabet;
  }
}