/**
 * Copyright 2014 Tag Spilman
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package technology.tag.codejam.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

public class DefaultContestReader<T extends TestCase<S>, S extends Solution>
		implements ContestReader<T, S> {

	private TestCaseReader<T, S> testCaseReader;

	public DefaultContestReader(TestCaseReader<T, S> testCaseReader) {
		this.testCaseReader = Preconditions.checkNotNull(testCaseReader,
				"testCaseReader must not be null");
	}

	@Override
	public final Contest<T, S> readContest(BufferedReader reader)
			throws IOException {
		int numberOfTestCases = readNumberOfTestCases(reader);
		List<T> testCases = readTestCases(reader);
		return new ImmutableContest<>(numberOfTestCases, testCases);
	}

	private int readNumberOfTestCases(BufferedReader reader) throws IOException {
		String line = reader.readLine().trim();
		return Integer.parseInt(line);
	}

	private List<T> readTestCases(BufferedReader reader) throws IOException {
		List<T> result = new ArrayList<>();
		T testCase = null;
		for (int i = 1; (testCase = testCaseReader.readTestCase(i, reader)) != null; i++) {
			result.add(testCase);
		}
		return result;
	}

}
