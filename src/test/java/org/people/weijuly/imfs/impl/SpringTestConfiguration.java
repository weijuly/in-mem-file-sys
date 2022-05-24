package org.people.weijuly.imfs.impl;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class SpringTestConfiguration {
}
