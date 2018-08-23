package com.cbs.edu.decoupled_reflection;

public interface MessageRenderer {
    void render();

    MessageProvider getMessageProvider();

    void setMessageProvider(MessageProvider messageProvider);
}
