package com.karthik.incidentmanagement.controller;

import com.karthik.incidentmanagement.dto.CommentRequestDto;
import com.karthik.incidentmanagement.entity.Comment;
import com.karthik.incidentmanagement.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{id}/comments")
    public Comment addComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentRequestDto dto) {

        return commentService.addComment(id, dto);
    }

    @GetMapping("/{id}/comments")
    public List<Comment> getComments(
            @PathVariable Long id) {

        return commentService.getComments(id);
    }
}