/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.libraryweasel.traytable;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class TrayTable {
    public static TableView<List<String>> create(List<String> headers, List<Integer> widths, List<List<String>> content) {
        final TableView<List<String>> table = new TableView<>();

        IntStream.range(0, headers.size()).forEach((final int index) -> {
            final TableColumn<List<String>, String> column = new TableColumn<>(headers.get(index));
            if (widths.size() > index) {column.setPrefWidth(widths.get(index)); }
            table.getColumns().add(column);
            column.setCellValueFactory(row ->
                new ReadOnlyStringWrapper((index < row.getValue().size()) ? row.getValue().get(index) : ""));
        });
        table.getItems().addAll(content);
        return table;
    }

    public static TableView<List<String>> create(List<String> headers, List<List<String>> content) {
        return create(headers, new ArrayList<>(), content);
    }
}
