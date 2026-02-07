package com.mayur29.BishnoiWeddingInvitation.service;

import com.mayur29.BishnoiWeddingInvitation.entity.Invitation;
import com.mayur29.BishnoiWeddingInvitation.repository.InvitationRepository;
import jdk.jfr.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class InvitationService {

    @Autowired
    private InvitationRepository invitationRepository;

    public ResponseEntity<?> getAllFromDb() {
        return ResponseEntity.ok(invitationRepository.findAll());
    }

    public ResponseEntity<String> createInvitationForUser(Invitation invitation, Integer templateId) {
        log.info("inside createInvitationForUser----->");
        String html = invitationRepository.getTemplateHtmlFromDb(templateId);
        log.info("html ::{}", html);
        html = html.replace("#groomName#", invitation.getGroomName()).replace("#brideName#", invitation.getBrideName());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<>(html, headers, HttpStatus.OK);
    }
}
