package dfa.parser;

import java.io.BufferedReader;
import java.io.IOException;

import dfa.DFA;
import dfa.DFAFactory;

public interface ISectionParser {
  public String parse(BufferedReader inputStream, DFA dfa, DFAFactory factory) throws IOException;
  public String getSectionName();
}
