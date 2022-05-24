package org.people.weijuly.imfs.impl;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.people.weijuly.imfs.spec.FileInfo;
import org.people.weijuly.imfs.spec.FileSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @And("{string} is created with name {string}")
    public void createFile(String type, String name) {
        if (type.equals(FILE)) {
            fs.touch(name);
        } else if (type.equals(DIRECTORY)) {
            fs.mkdir(name);
        }
    }
}
