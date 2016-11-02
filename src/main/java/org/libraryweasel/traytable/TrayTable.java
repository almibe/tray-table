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
