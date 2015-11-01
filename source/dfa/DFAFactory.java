package dfa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dfa.parser.AlphabetsParser;
import dfa.parser.FinalStatesParser;
import dfa.parser.ISectionParser;
import dfa.parser.InitStateParser;
import dfa.parser.StatesParser;
import dfa.parser.TestCasesParser;
import dfa.parser.TransitionTableParser;

// Read DFA definition, test cases from file
// create the corresponding DFA
public class DFAFactory {
	private DFA dfa = null;
	private List<String> testCases = null;

	private static Map<String, ISectionParser> parserList = new HashMap<String, ISectionParser>();
	static {
		ISectionParser parser = new AlphabetsParser();
		DFAFactory.parserList.put(parser.getSectionName(), parser);
		parser = new StatesParser();
		DFAFactory.parserList.put(parser.getSectionName(), parser);
		parser = new FinalStatesParser();
		DFAFactory.parserList.put(parser.getSectionName(), parser);
		parser = new InitStateParser();
		DFAFactory.parserList.put(parser.getSectionName(), parser);
		parser = new TransitionTableParser();
		DFAFactory.parserList.put(parser.getSectionName(), parser);
		parser = new TestCasesParser();
		DFAFactory.parserList.put(parser.getSectionName(), parser);
	}

	public DFAFactory() {
		this.dfa = new DFA();
		this.testCases = new ArrayList<String>();
	}

	public DFAFactory parseData(String dataFileName) {

		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(dataFileName));
			String line = inputStream.readLine();
			while (line != null) {
				line = line.trim();
				if (line.length() == 0) {
					line = inputStream.readLine();
					continue;
				}

				ISectionParser parser = DFAFactory.parserList.get(line);
				if (parser != null) {
					line = parser.parse(inputStream, this.dfa, this);
				} else {
					line = inputStream.readLine();
				}
			}

			inputStream.close();
		} catch (Exception e) {
		}

		return this;
	}

	public DFA getDFA() {
		return this.dfa;
	}

	public List<String> getTestCases() {
		return this.testCases;
	}

	public DFAFactory addTestCase(String testCase) {
		this.testCases.add(testCase);
		return this;
	}
}