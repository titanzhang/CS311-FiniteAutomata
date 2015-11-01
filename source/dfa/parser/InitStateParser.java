package dfa.parser;

import java.io.BufferedReader;
import java.io.IOException;

import dfa.DFA;
import dfa.DFAFactory;
import dfa.FAState;

public class InitStateParser implements ISectionParser {
	public String getSectionName() {
		return "[initState]";
	}

	public String parse(BufferedReader inputStream, DFA dfa, DFAFactory factory)
	    throws IOException {
		String line;
		while ((line = inputStream.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) {
				continue;
			} else {
				break;
			}
		}

		dfa.setInitState(new FAState(Integer.valueOf(line)));

		while ((line = inputStream.readLine()) != null) {
			line = line.trim();
			if (line.length() == 0) {
				continue;
			}
			if (line.charAt(0) == '[') {
				break;
			}
		}

		return line;
	}
}
