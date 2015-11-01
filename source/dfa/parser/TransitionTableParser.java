package dfa.parser;

import dfa.*;
import java.util.*;
import java.io.*;

public class TransitionTableParser implements ISectionParser {
  public String getSectionName() {
    return "[transitionTable]";
  }

  public String parse(BufferedReader inputStream, DFA dfa, DFAFactory factory) throws IOException {
    FATransitTable transitTable = new FATransitTable();
    List<FAAlphabet> alphabetList = dfa.getAlphabetList();

    String line;
    while ((line = inputStream.readLine()) != null) {
      line = line.trim();
      if (line.length() == 0) {
        continue;
      }
      if (line.charAt(0) == '[') {
        break;
      }

      String[] rule = line.split(",");
      if (rule.length != 3) {
        continue;
      }
      transitTable.add(
        new FAState(Integer.valueOf(rule[0])),
        alphabetList.get(Integer.valueOf(rule[1])),
        new FAState(Integer.valueOf(rule[2]))
      );
    }

    dfa.setTransitTable(transitTable);
    return line;
  }
}
