package com.questtest.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class DemoApplicationTests {

  @Autowired
  FireRepository fireRepository;
  @Autowired
  FiremanRepository firemanRepository;

  @Test
  public void testCreateFire() {

        Instant date = Instant.now();
	var fire = new Fire(8, date);
  var fire2 = new Fire(4, date);
  var fire3 = new Fire(9, date);
  var fire4 = new Fire(1, date);
  var fire5 = new Fire(8, date);
  var fire6 = new Fire(4, date);
  var fire7 = new Fire(9, date);
  var fire8 = new Fire(1, date);
  List<Fire> firesJohn = List.of(fire, fire2, fire3, fire4);
  List<Fire> firesMarc = List.of(fire5, fire6);
  List<Fire> firesLiz = List.of(fire7, fire8);
  var john = new Fireman("John", firesJohn);
  var marc = new Fireman("Marc", firesMarc);
  var liz = new Fireman("Liz", firesLiz);




// flush envoie les données instantanément à la base
// permettant au findById de récuperer les valeurs actualisées
	fireRepository.saveAndFlush(fire);
  fireRepository.saveAndFlush(fire2);
  fireRepository.saveAndFlush(fire3);
  fireRepository.saveAndFlush(fire4);
  fireRepository.saveAndFlush(fire5);
  fireRepository.saveAndFlush(fire6);
  fireRepository.saveAndFlush(fire7);
  fireRepository.saveAndFlush(fire8);
  firemanRepository.saveAndFlush(john);
  firemanRepository.saveAndFlush(marc);
  firemanRepository.saveAndFlush(liz);
  System.out.println("================================================");
  System.out.println(john.getFires().size());
  System.out.println(liz.getFires().size());
  System.out.println(marc.getFires().size());
  System.out.println(firemanRepository.getVeteran().get());


  Optional<Fireman> veteran = firemanRepository.getVeteran();

 // assertTrue(veteran.isPresent());
  //assertEquals("John", veteran.get().getName());

  }

}
