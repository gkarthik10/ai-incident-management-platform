package com.karthik.incidentmanagement.controller;

import com.karthik.incidentmanagement.dto.CommentRequestDto;
import com.karthik.incidentmanagement.entity.Comment;
import com.karthik.incidentmanagement.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PreAuthorize("hasAnyRole('ADMIN','ENGINEER','EMPLOYEE')")
    @PostMapping("/{id}/comments")
    public Comment addComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentRequestDto dto) {

        return commentService.addComment(id, dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','ENGINEER','EMPLOYEE')")
    @GetMapping("/{id}/comments")
    public List<Comment> getComments(
            @PathVariable Long id) {

        return commentService.getComments(id);
    }
}