package com.questtest.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class DemoApplicationTests {

  @Autowired
  FireRepository fireRepository;

  @Test
  public void testCreateFire() {
	int severity = 8;
        Instant date = Instant.now();
	var fire = new Fire(severity, date);

// flush envoie les données instantanément à la base
// permettant au findById de récuperer les valeurs actualisées
	fireRepository.saveAndFlush(fire);

	Optional<Fire> fromDB = fireRepository.findById(fire.getId());

	assertTrue(fromDB.isPresent());
	assertEquals(fire.getId(), fromDB.get().getId());
  assertEquals(date, fromDB.get().getDate());
	assertEquals(severity, fromDB.get().getSeverity());
  }


}
