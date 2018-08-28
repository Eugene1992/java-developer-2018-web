package com.cbs.edu.hello_world_xml.factory_method;

public class Stage {

    private static Stage stage;

    private Stage() {
    }

    public static Stage getInstance() {
        if (stage == null) {
            stage = new Stage();
        }
        return stage;
    }
}
