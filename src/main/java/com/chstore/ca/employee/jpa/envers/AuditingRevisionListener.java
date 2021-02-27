package com.chstore.ca.employee.jpa.envers;

import org.hibernate.envers.RevisionListener;

public class AuditingRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {

        AuditedRevisionEntity auditedRevisionEntity = (AuditedRevisionEntity) revisionEntity;

        //	String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        auditedRevisionEntity.setUser("chandrakumar");
    }
}
