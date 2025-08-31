package org.compsys704;

import java.io.Serializable;

public class SignalMessage implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;    // signal name
    private Object value;   // int, String, boolean, etc.

    public SignalMessage(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    // Convenience getters
    public int getIntValue() { return (Integer) value; }
    public String getStringValue() { return (String) value; }
    public boolean getBooleanValue() { return (Boolean) value; }
}
