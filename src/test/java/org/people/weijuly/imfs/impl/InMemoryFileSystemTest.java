package org.people.weijuly.imfs.impl;

import org.junit.jupiter.api.Test;
import org.people.weijuly.imfs.spec.FileInfo;
import org.people.weijuly.imfs.spec.FileSystem;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryFileSystemTest {
    @Test
    public void test() {
        FileSystem fs = new InMemoryFileSystem();

        assertNotNull(fs);
        assertEquals(0, fs.ls().size());
        assertEquals("/", fs.pwd());

        fs.touch("file_01");
        assertEquals(1, fs.ls().size());
        assertEquals("file_01", fs.ls().get(0).name());
        assertTrue(fs.ls().get(0).created() <= Instant.now().getEpochSecond());
        assertEquals(FileInfo.FILE, fs.ls().get(0).type());

        fs.mkdir("dir_01");
        assertEquals(2, fs.ls().size());
        assertEquals("dir_01", fs.ls().get(1).name());
        assertTrue(fs.ls().get(1).created() <= Instant.now().getEpochSecond());
        assertEquals(FileInfo.DIR, fs.ls().get(1).type());

        fs.cd("dir_01");
        assertEquals(0, fs.ls().size());
        assertEquals("/dir_01/", fs.pwd());

        fs.cd("..");
        assertEquals("/", fs.pwd());
        assertEquals(2, fs.ls().size());

        fs.cd("dir_01");
        fs.mkdir("dir_02");
        assertEquals(1, fs.ls().size());

        fs.cd("dir_02");
        assertEquals(0, fs.ls().size());
        assertEquals("/dir_01/dir_02/", fs.pwd());

        fs.cd("/dir_01/dir_02/");
        assertEquals(0, fs.ls().size());
        assertEquals("/dir_01/dir_02/", fs.pwd());

        fs.cd("dir_xy"); // error, doesn't change state

        fs.cd("..");
        assertEquals("/dir_01/", fs.pwd());

        fs.cd("..");
        assertEquals("/", fs.pwd());

        fs.ls().forEach(System.out::println);

    }
}
