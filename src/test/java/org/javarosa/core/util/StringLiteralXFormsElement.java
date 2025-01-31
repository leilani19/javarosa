/*
 * Copyright 2019 Nafundi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.javarosa.core.util;

import static org.javarosa.core.util.XFormsElement.buildAttributesString;

import java.util.Map;

public class StringLiteralXFormsElement implements XFormsElement {
    private final String name;
    private final Map<String, String> attributes;
    private final String innerHtml;

    StringLiteralXFormsElement(String name, Map<String, String> attributes, String innerHtml) {
        this.name = name;
        this.attributes = attributes;
        this.innerHtml = innerHtml;
    }

    @Override
    public String asXml() {
        String attributesString = buildAttributesString(attributes);
        return String.format(
            "<%s%s>%s</%s>",
            name,
            attributesString.isEmpty() ? "" : " " + attributesString,
            innerHtml,
            name
        );
    }

}
