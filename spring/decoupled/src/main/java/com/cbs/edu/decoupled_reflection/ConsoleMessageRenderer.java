package com.cbs.edu.decoupled_reflection;

public class ConsoleMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("Renderer is null!");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
}
