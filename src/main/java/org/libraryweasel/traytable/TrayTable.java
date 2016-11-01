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

import java.util.Iterator;
import java.util.List;

public final class TrayTable {
    public static TableView<List<String>> create(List<String> headers, List<List<String>> content) {
        TableView<List<String>> table = new TableView<>();
        Iterator<String> iterator = headers.iterator();
        int index = 0;

        while (iterator.hasNext()) {
            String columnTitle = iterator.next();
            TableColumn<List<String>, String> column = new TableColumn<>(columnTitle);
            table.getColumns().add(column);
            final int current = index;
            column.setCellValueFactory(row -> {
                if (current < row.getValue().size()) {
                    return new ReadOnlyStringWrapper(row.getValue().get(current));
                } else {
                    return new ReadOnlyStringWrapper("");
                }
            });
            index++;
        }
        table.getItems().addAll(content);
        return table;
    }
}
