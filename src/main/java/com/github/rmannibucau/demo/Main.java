/**
 * Copyright (C) 2006-2019 Talend Inc. - www.talend.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.rmannibucau.demo;

import java.util.stream.Stream;

import com.github.rmannibucau.demo.cxf.BookStore;
import com.github.rmannibucau.demo.cxf.schema.Book;

public class Main {
    public static void main(final String[] args) {
        // ensure java-templating sources were added and filtered
        Stream.of(Variables.values())
                .peek(it -> {
                    if (it.getValue().startsWith("${")) {
                        throw new IllegalArgumentException("Bad source used, this is filtered through maven build normally");
                    }
                })
                .forEach(it -> System.out.println(it.name() + ": " + it.getValue()));

        // ensure CXF sources were added
        System.out.println(new BookStore());
        System.out.println(new Book());
    }

    private Main() {
        // no-op
    }
}
