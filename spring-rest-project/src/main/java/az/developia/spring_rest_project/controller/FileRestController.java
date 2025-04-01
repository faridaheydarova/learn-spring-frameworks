package az.developia.spring_rest_project.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import az.developia.spring_rest_project.entity.FileModel;
import jakarta.annotation.security.PermitAll;

@RestController
@RequestMapping(path="/files")
public class FileRestController {



	@PostMapping(path = "/upload")
	@PreAuthorize(value="hasAthority('UPLOAD_FILE')")
	public FileModel uploadFile(@RequestParam(name = "file", required = false) MultipartFile file) {
		String fileName = file.getOriginalFilename();
		try {
			InputStream stream = file.getInputStream();
			File java = new File("C:/java");
			if (!java.exists()) {
				java.mkdir();
			}
			UUID uuid = UUID.randomUUID();
			String randomName = uuid.toString();
			String format = fileName.substring(fileName.lastIndexOf("."));
			randomName += format;
			fileName = randomName;
			Files.copy(stream, Paths.get("C:/java/" + randomName), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		FileModel model = new FileModel();
		model.setFileName("http://localhost:8024/files/download/" + fileName);
		return model;
	}

	@GetMapping(path = "/download/{filename:.+}")
	@PermitAll
	@PreAuthorize(value="hasAthority('DOWNLOAD_FILE')")
	public ResponseEntity<Resource> downoald(@PathVariable String filename) {
		try {
			Resource file = new UrlResource(Paths.get("C:/java").resolve(filename).toUri());
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
					.body(file);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
}

