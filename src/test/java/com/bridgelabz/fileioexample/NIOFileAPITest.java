package com.bridgelabz.fileioexample;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {
	private static String HOME= "/home/govind";
	private static String PLAY_WITH_NIO = "TempPlayGround";

	@Test
	public void gibenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
		Path dir = Paths.get(HOME+"/"+PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new Java8WatchServiceExample(dir).processEvents();
	}
	@Test
	public void givenPathWhenCheckedThemConfirm() throws IOException {
		//Check file exists
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

		//Delete file and check file not exit
		Path playPath = Paths.get(HOME,"/"+PLAY_WITH_NIO);
		if (Files.exists(playPath))
			FileUtils.deleteFolder(playPath.toFile());
		Assert.assertTrue(Files.notExists(playPath));

		//Create Directory
		Files.createDirectories(playPath);
		Assert.assertTrue(Files.exists(playPath));

		//Create File
		IntStream.range(0,9).forEach(cntr->{
			Path tempFile = Paths.get(playPath+"/temp"+cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			}
			catch(IOException e) {
				Assert.assertTrue(Files.exists(tempFile));
			}
		});
		//List Files,Directories as well as Files with Extension
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path->path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);

	}
}
