package org.people.weijuly.imfs.impl;

public class FileNode extends Node {

    String contents;

    public FileNode(String name, String path, Node parent) {
        super(name, path, parent);
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
