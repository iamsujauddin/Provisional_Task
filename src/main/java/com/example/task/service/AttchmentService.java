package com.example.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.task.entity.Attachment;
import com.example.task.repository.AttachmentRepository;

@Service
public class AttchmentService {

	@Autowired
	private AttachmentRepository attachmentRepository;

	public Attachment uploadFileInMemory(MultipartFile file) throws Exception {
		Attachment attachment = new Attachment();
		try {
			attachment.setFileName(file.getOriginalFilename());
			attachment.setFileType(file.getContentType());
			attachment.setData(file.getBytes());
			return attachmentRepository.save(attachment);
		} catch (Exception e) {
			throw new Exception("File could not be uploaded" + file.getOriginalFilename());
		}

	}

	public Attachment getAttchment(int fileId) throws Exception {
		Attachment attachment = null;
		try {
			attachment = attachmentRepository.getByAttachment(fileId);
		} catch (Exception e) {
			throw new Exception("File Not Found");
		}
		return attachment;

	}

}
