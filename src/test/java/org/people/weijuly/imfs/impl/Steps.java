package org.people.weijuly.imfs.impl;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.people.weijuly.imfs.spec.FileInfo;
import org.people.weijuly.imfs.spec.FileSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Steps {

    FileSystem fs;

    final String FILE = "FILE";
    final String DIRECTORY = "DIRECTORY";

    @When("filesystem is created")
    public void create() {
        fs = new InMemoryFileSystem();
    }

    @Then("pwd should return directory {string}")
    public void checkPresentWorkingDirectory(String dir) {
        assertEquals(dir, fs.pwd());
    }

    @Then("ls should return {int} items")
    public void checkListSize(Integer items) {
        assertEquals(items, fs.ls().size());
    }

    @Then("item {int} of ls should have name {string}")
    public void checkListItemName(Integer i, String name) {
        assertEquals(name, fs.ls().get(i).name());
    }

    @Then("item {int} of ls should be of type {string}")
    public void checkListItemType(Integer i, String type) {
        if (type.equals(FILE)) {
            assertEquals(FileInfo.FILE, fs.ls().get(i).type());
        } else if (type.equals(DIRECTORY)) {
            assertEquals(FileInfo.DIR, fs.ls().get(i).type());
        }
    }

    @When("touch {string}")
    public void touch(String file) {
        fs.touch(file);
    }
    @When("cd to {string}")
    public void cd(String dir) {
        fs.cd(dir);
    }

    @When("mkdir {string}")
    public void mkdir(String dir){
        fs.mkdir(dir);
    }
}
