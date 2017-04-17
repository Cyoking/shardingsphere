/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.parser.mysql;

import com.dangdang.ddframe.rdb.sharding.api.fixture.ShardingRuleMockBuilder;
import com.dangdang.ddframe.rdb.sharding.constants.DatabaseType;
import com.dangdang.ddframe.rdb.sharding.parser.AbstractBaseParseTest;
import com.dangdang.ddframe.rdb.sharding.parser.result.merger.MergeContext;
import com.dangdang.ddframe.rdb.sharding.parser.result.router.ConditionContext;
import com.dangdang.ddframe.rdb.sharding.parser.sql.context.TableContext;
import com.dangdang.ddframe.rdb.sharding.parser.sql.parser.SQLParserEngine;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Collection;
import java.util.Collections;

@RunWith(Parameterized.class)
public final class OrParseTest extends AbstractBaseParseTest {
    
    public OrParseTest(
            final String testCaseName, final String sql, final String expectedSQL, 
            final Collection<TableContext> expectedTables, final Collection<ConditionContext> expectedConditionContext, final MergeContext expectedMergeContext) {
        super(testCaseName, sql, expectedSQL, expectedTables, expectedConditionContext, expectedMergeContext);
    }
    
    @Parameters(name = "{0}")
    public static Collection<Object[]> dataParameters() {
        return AbstractBaseParseTest.dataParameters("com/dangdang/ddframe/rdb/sharding/parser/mysql/or/");
    }
    
    // TODO 归并字段，整合进mySQL测试
    // TODO 暂时不支持or
    @Test
    @Ignore
    public void assertParse() {
        new SQLParserEngine(DatabaseType.MySQL, getSql(), new ShardingRuleMockBuilder()
                .addShardingColumns("id").addShardingColumns("user_id").addShardingColumns("name").addShardingColumns("age")
                .addShardingColumns("days").addShardingColumns("fee").addShardingColumns("travel_date").addShardingColumns("long").build(), Collections.emptyList()).parseStatement();
    }
}
