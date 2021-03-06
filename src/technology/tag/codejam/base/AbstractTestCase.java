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

import com.google.common.base.Preconditions;

public abstract class AbstractTestCase<S extends Solution> implements
		TestCase<S> {

	private final int caseNumber;

	public AbstractTestCase(int caseNumber) {
		super();
		Preconditions.checkArgument(caseNumber >= 1);
		this.caseNumber = caseNumber;
	}

	@Override
	public int getCaseNumber() {
		return caseNumber;
	}

}