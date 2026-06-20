package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.CommentRequestDto;
import com.karthik.incidentmanagement.entity.Comment;

import java.util.List;

public interface CommentService {

    Comment addComment(
            Long incidentId,
            CommentRequestDto dto);

    List<Comment> getComments(
            Long incidentId);
}