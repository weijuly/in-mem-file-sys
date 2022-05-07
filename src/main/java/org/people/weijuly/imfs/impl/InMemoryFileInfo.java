package org.people.weijuly.imfs.impl;


import org.people.weijuly.imfs.spec.FileInfo;

public class InMemoryFileInfo implements FileInfo {

    Long created;
    String name;
    String type;


    public InMemoryFileInfo(Node node) {
        created = node.getCreated();
        name = node.getName();
        type = node instanceof FileNode ? "FILE" : "DIR";
    }

    @Override
    public Long created() {
        return created;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public String toString() {
        System.identityHashCode(this);
        return String.format("InMemoryFileInfo@%d{created: %s, name: %s, type: %s}",
                System.identityHashCode(this), created, name, type);
    }
}
