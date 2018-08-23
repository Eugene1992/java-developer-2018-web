package com.cbs.edu.hello_world_xml;

public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
