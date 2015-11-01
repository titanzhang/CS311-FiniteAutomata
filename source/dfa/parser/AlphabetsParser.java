package dfa.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dfa.DFA;
import dfa.DFAFactory;
import dfa.FAAlphabet;

public class AlphabetsParser implements ISectionParser {
  public String getSectionName() {
    return "[alphabets]";
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

    List<FAAlphabet> alphabetList = new ArrayList<FAAlphabet>();
    boolean groupStart = false;
    StringBuffer groupString = null;
    String[] tokens = lines.toString().split(",");
    for (int i = 0; i < tokens.length; i ++) {
      String token = tokens[i];
      if (token.length() > 2) { // format error, ommit
        continue;
      }

      if ((token.length() == 2) && (token.charAt(0) == '{')) { // group start
        groupString = new StringBuffer();
        groupString.append(token.charAt(1));
        groupStart = true;
      } else if ((token.length() == 2) && (token.charAt(token.length() - 1) == '}')) { // group end
        groupString.append(token.charAt(0));
        groupStart = false;
        alphabetList.add(new FAAlphabet(groupString.toString().toCharArray()));
      } else {
        if (groupStart) { // in a group
          groupString.append(token.charAt(0));
        } else { // single alphabet
          alphabetList.add(new FAAlphabet(token.charAt(0)));
        }
      }
    }

    dfa.setAlphabetList(alphabetList);
    return line;
  }
}