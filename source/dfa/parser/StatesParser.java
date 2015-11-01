package dfa.parser;

import dfa.*;
import java.util.*;
import java.io.*;

public class StatesParser implements ISectionParser {
  public String getSectionName() {
    return "[states]";
  }

  public String parse(BufferedReader inputStream, DFA dfa, DFAFactory factory) throws IOException {
    StringBuffer lines = new StringBuffer(1);
    String line;
    while ((line = inputStream.readLine()) != null) {
      line = line.trim();
      if (line.length() == 0) {
        continue;
      }

      if (line.charAt(0) != '[') {
        lines.append(line);
      } else {
      	break;
      }
    }

    List<FAState> states = new ArrayList<FAState>();
    String[] tokens = lines.toString().split(",");
    for (int i = 0; i < tokens.length; i ++) {
      String token = tokens[i];
      states.add(new FAState(Integer.valueOf(token)));
    }

    this.setStates(states, dfa);
    return line;
  }

  protected void setStates(List<FAState> states, DFA dfa) {
    dfa.setStateList(states);
  }
}
