package dfa.parser;

import dfa.*;
import java.util.*;
import java.io.*;

public class TestCasesParser implements ISectionParser {
  public String getSectionName() {
    return "[testCases]";
  }

  public String parse(BufferedReader inputStream, DFA dfa, DFAFactory factory) throws IOException {
    String line;
    while ((line = inputStream.readLine()) != null) {
      line = line.trim();
      if (line.length() == 0) {
        continue;
      }
      if (line.charAt(0) == '[') {
        break;
      }

      factory.addTestCase(line.replaceAll("\"", ""));
    }

    return line;
  }
}
