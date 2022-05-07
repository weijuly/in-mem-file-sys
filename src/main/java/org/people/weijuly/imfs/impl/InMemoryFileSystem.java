package org.people.weijuly.imfs.impl;

import org.apache.logging.log4j.util.Strings;
import org.people.weijuly.imfs.spec.FileInfo;
import org.people.weijuly.imfs.spec.FileSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InMemoryFileSystem implements FileSystem {

    DirectoryNode root;
    DirectoryNode curr;

    public InMemoryFileSystem() {
        root = new DirectoryNode("root", "/", null);
        curr = root;
    }

    @Override
    public List<FileInfo> ls() {
        return curr
                .getContents()
                .stream()
                .map(InMemoryFileInfo::new)
                .collect(Collectors.toList());
    }

    @Override
    public void cd(String path) {
        if (parent(path)) {
            if (Objects.isNull(curr.getParent())) {
                System.out.printf("ERROR: Cannot cd to %s from %s\n", path, curr.getPath());
                return;
            }
            curr = (DirectoryNode) curr.getParent();
        } else if (absolute(path)) {
            List<String> tokens = Arrays
                    .stream(path.split("/"))
                    .filter(Strings::isNotEmpty)
                    .collect(Collectors.toList());
            DirectoryNode temp = root;
            for (String token: tokens) {
                Boolean found = false;
                for (Node node: temp.getContents()) {
                    if (node instanceof DirectoryNode && node.getName().equals(token)){
                        temp = (DirectoryNode) node;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.printf("ERROR: Cannot cd to %s\n", path);
                    return;
                }
            }
            curr = temp;
        } else {
            Node node = curr
                    .getContents()
                    .stream()
                    .filter(n -> n instanceof DirectoryNode)
                    .filter(n -> n.getName().equals(path))
                    .findFirst()
                    .orElse(null);
            if (Objects.isNull(node)) {
                System.out.printf("ERROR: Cannot cd to %s from %s\n", path, curr.getPath());
                return;
            }
            curr = (DirectoryNode) node;
        }
    }

    @Override
    public void touch(String name) {
        curr.add(new FileNode(name, curr.getPath(), curr));
    }

    @Override
    public void mkdir(String name) {
        curr.add(new DirectoryNode(name, String.format("%s%s/", curr.getPath(), name), curr));
    }

    @Override
    public void cat(String path) {

    }

    @Override
    public void rm(String path) {

    }

    @Override
    public String pwd() {
        return curr.getPath();
    }

    @Override
    public void cp(String src, String dst) {

    }

    private Boolean absolute(String path) {
        return path.startsWith("/");
    }

    private Boolean parent(String path) {
        return path.equals("..");
    }


}
