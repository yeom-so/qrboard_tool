package kr.co.digigroove.qrboard_tool.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileUtils {

	public static String saveFile(final String savePath, final MultipartFile sourcefile) {

		String fileName = RandomStringUtils.randomAlphabetic(3) + System.currentTimeMillis() + ".png";
		String targetFilePath = savePath + File.separator + fileName;

		if ( sourcefile == null || sourcefile.isEmpty() ) {
			return null;
		}

		File saveFolder = new File( savePath );
		if ( !saveFolder.exists() || saveFolder.isFile() ) {
			saveFolder.mkdirs();
		}

		File targetFile = new File( targetFilePath );

		try {
			sourcefile.transferTo( targetFile );
		} catch (IOException e) {
			e.printStackTrace();
		}

		return targetFilePath;
	}

	public static void deleteFile ( final String filePath ) throws FileNotFoundException {

		File file = new File( filePath );

		if ( file.exists() && file.isFile()) {
			if (!file.delete()) throw new RuntimeException("file delete failed.");
		} else {
			throw new FileNotFoundException( "delete file not found : " + file.getAbsolutePath() );
		}
	}

	public static String copyFile ( String realPath, String savePath ) {
		String newfileName = RandomStringUtils.randomAlphabetic(3) + System.currentTimeMillis() + ".png";
		String newFilePath = savePath + File.separator + newfileName;
		System.out.println(">>>oldFilePath" + realPath);

		try {
			// 복사할 대상 파일을 지정해준다.
			File oldFile = new File(realPath);
			if ( oldFile.exists() && oldFile.isFile()) {
				// FileInputStream 는 File object를 생성자 인수로 받을 수 있다.
				FileInputStream input = new FileInputStream(oldFile);
				// 복사된 파일의 위치를 지정해준다.
				FileOutputStream output = new FileOutputStream(new File(newFilePath));

				int readBuffer = 0;
				byte [] buffer = new byte[512];
				while((readBuffer = input.read(buffer)) != -1) {
					output.write(buffer, 0, readBuffer);
				}
				System.out.println("파일이 복사되었습니다.");
				// 생성된 InputStream Object를 닫아준다.
				input.close();
				// 생성된 OutputStream Object를 닫아준다.
				output.close();
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		return newFilePath;
	}
}
