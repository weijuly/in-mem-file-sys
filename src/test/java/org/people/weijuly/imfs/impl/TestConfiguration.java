package org.people.weijuly.imfs.impl;

import org.people.weijuly.imfs.spec.FileSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public FileSystem fileSystem() {
        return new InMemoryFileSystem();
    }
}
