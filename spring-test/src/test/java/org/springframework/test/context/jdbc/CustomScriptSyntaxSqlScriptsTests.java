/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

/**
 * Integration tests that verify support for custom SQL script syntax
 * configured via {@link SqlConfig @SqlConfig}.
 *
 * @author Sam Brannen
 * @since 4.1
 */
@ContextConfiguration(classes = EmptyDatabaseConfig.class)
@DirtiesContext
class CustomScriptSyntaxSqlScriptsTests extends AbstractTransactionalTests {

	@Test
	@Sql("schema.sql")
	@Sql(scripts = "data-add-users-with-custom-script-syntax.sql",//
			config = @SqlConfig(commentPrefixes = {"`", "%%"}, blockCommentStartDelimiter = "#$", blockCommentEndDelimiter = "$#", separator = "@@"))
	void methodLevelScripts() {
		assertNumUsers(3);
	}

}
