package com.maksymmikitiuk.university.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "mail")
public class Mail {

    @Id
    @Column(name = "email_id", unique = true)
    @SequenceGenerator(name = "email_seq", sequenceName = "email_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
    private Long id;

    @Column(name = "email_to", unique = true,
            nullable = false, length = 500)
    private String to;

    @Column(name = "email_subject")
    private String subject;

    @Column(name = "email_text")
    private String text;

    @Column(name = "email_path_to_attachment")
    private String pathToAttachment;

    @Column(name = "email_send", nullable = false)
    private boolean send;

    @Column(name = "email_send_date", nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

    @Transient
    private Map model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPathToAttachment() {
        return pathToAttachment;
    }

    public void setPathToAttachment(String pathToAttachment) {
        this.pathToAttachment = pathToAttachment;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Map getModel() {
        return model;
    }

    public void setModel(Map model) {
        this.model = model;
    }
}
