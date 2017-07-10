/*
 * Copyright 2014-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazon.janusgraph.diskstorage.dynamodb;

import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Structure of update and condition expressions required for a DynamoDB conditional update.
 *
 * The expressions share an attribute value and name map.
 * @author Alexander Patrikalakis
 * @author Michael Rodaitis
 */
@RequiredArgsConstructor
public class Expression {

    @Getter
    private final String updateExpression;
    @Getter
    private final String conditionExpression;
    private final Map<String, AttributeValue> attributeValues;
    private final Map<String, String> attributeNames;

    public Map<String, AttributeValue> getAttributeValues() {
        // DynamoDB expects null expression maps when they are empty.
        if (attributeValues == null || attributeValues.isEmpty()) {
            return null;
        }
        return attributeValues;
    }
}
