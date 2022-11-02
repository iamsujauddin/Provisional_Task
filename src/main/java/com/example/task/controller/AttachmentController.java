package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.ResponseDto;
import com.example.task.entity.Attachment;
import com.example.task.service.AttchmentService;

@RestController
public class AttachmentController {

	@Autowired
	private AttchmentService attchmentService;

	@GetMapping("/hello")
	public String sayHello() {
		return "HI";
	}

	@PostMapping("/upload")
	public ResponseDto uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
		Attachment attachment = null;
		attachment = attchmentService.uploadFileInMemory(file);
		return new ResponseDto(attachment.getId(), attachment.getFileName(), attachment.getFileType());
	}

	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int fileId) throws Exception {
		Attachment attachment = null;
		attachment = attchmentService.getAttchment(fileId);
		String headerFile = "Attchment:fileName =\"" + attachment.getFileName() + "\"";
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, headerFile).body(new ByteArrayResource(attachment.getData()));

	}
}
