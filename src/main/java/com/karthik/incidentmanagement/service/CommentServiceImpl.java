package com.karthik.incidentmanagement.service;

import com.karthik.incidentmanagement.dto.CommentRequestDto;
import com.karthik.incidentmanagement.entity.Comment;
import com.karthik.incidentmanagement.entity.Incident;
import com.karthik.incidentmanagement.exception.IncidentNotFoundException;
import com.karthik.incidentmanagement.repository.CommentRepository;
import com.karthik.incidentmanagement.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl
        implements CommentService {

    private final CommentRepository commentRepository;
    private final IncidentRepository incidentRepository;

    @Override
    public Comment addComment(
            Long incidentId,
            CommentRequestDto dto) {

        Incident incident =
                incidentRepository.findById(incidentId)
                        .orElseThrow(() ->
                                new IncidentNotFoundException(
                                        "Incident not found with id: "
                                                + incidentId));

        Comment comment = Comment.builder()
                .message(dto.getMessage())
                .createdAt(LocalDateTime.now())
                .incident(incident)
                .build();

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Long incidentId) {

        return commentRepository
                .findByIncidentId(incidentId);
    }
}