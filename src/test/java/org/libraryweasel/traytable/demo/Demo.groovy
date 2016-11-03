package org.libraryweasel.traytable.demo;

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import org.libraryweasel.traytable.TrayTable

public class Demo extends Application {
    public static void main(String[] args) { launch(Demo.class) }

    @Override
    public void start(Stage primaryStage) throws Exception {
        def table = TrayTable.create(["Col Test 1", "Col Test 2", "Half Empty Column", "Empty Column"],
            [100,200,500],
            [["a", "b"],
            ["c", "d"],
            ["e", "f", "g"],
            ["h", "i", "j"]]
        )

        Scene scene = new Scene(table, 1400, 800)
        primaryStage.title = "Tray Table Demo"
        primaryStage.scene = scene
        primaryStage.show()
    }
}
