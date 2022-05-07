package org.people.weijuly.imfs.impl;


import java.time.Instant;

public abstract class Node {
    Long created;
    String name;
    String path;
    Node parent;

    public Node(String name, String path, Node parent) {
        this.created = Instant.now().getEpochSecond();
        this.name = name;
        this.path = path;
        this.parent = parent;
    }

    public Long getCreated() {
        return created;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public Node getParent() {
        return parent;
    }
}
