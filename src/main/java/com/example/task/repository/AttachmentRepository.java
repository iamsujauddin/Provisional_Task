package com.example.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.task.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
	
	@Query(value="SELECT * FROM db_example.attachmentzw where attachmentId=?;",nativeQuery = true)
	Attachment getByAttachment(int fileId);

}
