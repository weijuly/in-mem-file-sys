package org.people.weijuly.imfs.impl;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode extends Node {

    List<Node> contents;

    public DirectoryNode(String name, String path, Node parent) {
        super(name, path, parent);
        contents = new ArrayList<>();
    }

    public void add(Node node) {
        contents.add(node);
    }

    public void remove(Node node) {
    }

    public List<Node> getContents(){
        return contents;
    }
}
