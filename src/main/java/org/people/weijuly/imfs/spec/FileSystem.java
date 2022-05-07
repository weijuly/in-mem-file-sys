package org.people.weijuly.imfs.spec;

import java.util.List;

public interface FileSystem {

    List<FileInfo> ls();

    void cd(String path);

    void touch(String name);

    void mkdir(String name);

    void cat(String path);

    void rm(String path);

    String pwd();

    void cp(String src, String dst);
}
