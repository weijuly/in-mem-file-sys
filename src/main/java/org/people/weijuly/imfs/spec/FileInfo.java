package org.people.weijuly.imfs.spec;

public interface FileInfo {

    String FILE = "FILE";
    String DIR = "DIR";

    Long created();

    String name();

    String type();

}
