package com.questtest.demo;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Fire {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int severity;
  private Instant date;
  @ManyToOne
  private Fireman fireman;

  public Fire() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getSeverity() {
    return severity;
  }

  public void setSeverity(int severity) {
    this.severity = severity;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public Fireman getFireman() {
    return fireman;
  }

  public void setFireman(Fireman fireman) {
    this.fireman = fireman;
  }

  public Fire(int severity, Instant date) {
    this.severity = severity;
    this.date = date;
  }
}
