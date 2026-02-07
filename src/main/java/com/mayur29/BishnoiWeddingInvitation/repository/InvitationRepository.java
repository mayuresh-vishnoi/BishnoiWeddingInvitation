package com.mayur29.BishnoiWeddingInvitation.repository;

import com.mayur29.BishnoiWeddingInvitation.entity.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends JpaRepository<Invitation,Integer> {
    @Query(value = "SELECT TEMPLATE_HTML FROM TEMPLATE WHERE ID = :templateId", nativeQuery = true)
    String getTemplateHtmlFromDb(int templateId);
}
