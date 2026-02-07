package com.mayur29.BishnoiWeddingInvitation.controller;

import com.mayur29.BishnoiWeddingInvitation.entity.Invitation;
import com.mayur29.BishnoiWeddingInvitation.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return invitationService.getAllFromDb();
    }

    @GetMapping("/home")
    public String openInvitation() {
        return "Main";
    }

    @PostMapping("/create/{templateId}")
    public ResponseEntity<?> createInvitation(@PathVariable Integer templateId,
                                              @ModelAttribute Invitation invitation){
        return invitationService.createInvitationForUser(invitation,templateId);
    }
}
