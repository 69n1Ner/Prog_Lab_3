package Enums;

public enum Tool {
    SYRGERY_TOOLS("Хирургические инструменты");

    private final String tools;

    Tool(String tools) {
        this.tools = tools;
    }

    public String getSyrgerytools() {
        return tools;
    }

    @Override
    public String toString() {
        return tools;
    }
}
