package com.san.exam.board.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UploadController {

	@Value("${file.upload.path}") // appInfo.properties 파일에서 업로드 경로을 불러옴
	private String uploadPath;

	@GetMapping("uploadForm")
	public void getUploadForm() {
		log.info(uploadPath);
	}

	@PostMapping("/uploadsAjax")
	@ResponseBody // ajax를 사용하지 않을 시  @ResponseBody제거 return에 페이지 입력
	public List<String> uploadFile(@RequestPart MultipartFile[] uploadFiles) { // @RequestPart 스프링에선 세트, []form에 multiple있으면 배열,

		List<String> imageList = new ArrayList<>();
		// 배열은 무조건 반복문
		for (MultipartFile uploadFile : uploadFiles) {
			if (uploadFile.getContentType().startsWith("image") == false) {
				System.err.println("this file is not image type");
				return null;
			}

			// 실제 업로드한 원본 파일명
			String originalName = uploadFile.getOriginalFilename();
 			String fileName = originalName.substring(originalName.lastIndexOf("//") + 1); // 경로가 포함되어있기때문에 substr으로 제거 
			
			System.out.println("fileName : " + fileName);

			// 서버 내부에
			// 날짜 폴더 생성 - 오래된 파일 관리 용이
			String folderPath = makeFolder();
			// UUID - 기존의 이름대신 구분 용이하게 랜덤값을 부여
			String uuid = UUID.randomUUID().toString();
			// 저장할 파일 이름 중간에 "_"를 이용하여 구분

			String uploadFileName = folderPath + File.separator + uuid + "_" + fileName; // 날짜 폴더 + uuid로 파일명 생성

			String saveName = uploadPath + File.separator + uploadFileName; // 실제 저장 경로 + 파일이름

			Path savePath = Paths.get(saveName);
			// Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
			System.out.println("path : " + saveName);
			try {
				uploadFile.transferTo(savePath);
				// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
			} catch (IOException e) {
				e.printStackTrace();
			}
			// DB에 해당 경로 저장
			// 1) 사용자가 업로드할 때 사용한 파일명
			// 2) 실제 서버에 업로드할 때 사용한 경로
			imageList.add(setImagePath(uploadFileName));
		}

		return imageList;
	}

	private String makeFolder() {
		String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		// LocalDate를 문자열로 포멧
		String folderPath = str.replace("/", File.separator); // 윈도우의 폴더 구분 역슬래쉬(\) -> 리눅스, 자바 폴더 구분 슬래쉬 (/)
		File uploadPathFoler = new File(uploadPath, folderPath);
		// File newFile= new File(dir,"파일명");
		if (uploadPathFoler.exists() == false) {
			uploadPathFoler.mkdirs();
			// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다. .exists() - 파일 이름 기반으로 경로에 폴더 존재 유무 확인
			// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
			// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
		}
		return folderPath;
	}

	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
		// 리눅스, 자바 폴더 구분 슬래쉬 (/) -> 윈도우의 폴더 구분 역슬래쉬(\)
	}
}
