package com.rohan.employeepayrollservice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class NIOFileAPITest {

	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	void test() throws IOException {
		// Check file exists
		Path homePath = Paths.get(HOME);
		assertTrue(Files.exists(homePath));

		// Delete file and check file not exists
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath))
			FileUtils.deleteFiles(playPath.toFile());
		assertTrue(Files.notExists(playPath));

		// Create directory
		Files.createDirectory(playPath);
		assertTrue(Files.exists(playPath));

		// Create Files
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
				assertTrue(Files.exists(tempFile));
			}
		});

		// List files, directories as well as files with extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}

}
