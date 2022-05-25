package org.people.weijuly.imfs.impl;


import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
@CucumberContextConfiguration
public class InMemoryFileSystemTest {

}
