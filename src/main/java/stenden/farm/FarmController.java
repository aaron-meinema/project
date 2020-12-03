package stenden.farm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stenden.farm.data.jpa.CowRepository;
import stenden.farm.data.jpa.HouseRepository;
import stenden.farm.data.jpa.PigRepository;
import stenden.farm.data.model.Cow;
import stenden.farm.data.model.House;
import stenden.farm.data.model.Pig;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


@RestController

@RequestMapping("/farm")
public class FarmController {

  @Autowired
  private CowRepository cowRepository;

  @Autowired
  private HouseRepository houseRepository;

  @Autowired
  private PigRepository pigRepository;

  @GetMapping
  public List<House> getAllHouses(){
    return houseRepository.findAll();
  }

  @GetMapping("/cows")
  public List<Cow> getAllCows(){
    return cowRepository.findAll();
  }

  @GetMapping("/pigs")
  public List<Pig> getAllPigs(){
    return pigRepository.findAll();
  }

  @PostMapping("/cows")
  public Cow createCow(@RequestBody Cow cow) {
    return cowRepository.save(cow);
  }

  @PostMapping("/")
  public House createHouse(@RequestBody House house) {
    return houseRepository.save(house);
  }
  @PostMapping("/pigs")
  public Pig createPig(@RequestBody Pig pig) {
    return pigRepository.save(pig);
  }

  @GetMapping("/cowsinhouse/{id}")
  public ResponseEntity<List<Cow>> cowInHouse(@PathVariable(value = "id") Long id) {
    List<Cow> cows = houseRepository.getOne(id).getCows();
    if(cows == null){
      throw new NotFound("House on " + id + " was not found");
    }
    return ResponseEntity.ok(cows);
  }

  @GetMapping("/pigsinhouse/{id}")
  public ResponseEntity<List<Pig>> pigInHouse(@PathVariable(value = "id") Long id) {
    List<Pig> pigs = houseRepository.getOne(id).getPigs();
    if(pigs == null){
      throw new NotFound("House on " + id + " was not found");
    }
    return ResponseEntity.ok(pigs);
  }

  @PutMapping("/cows/{id}")
  public ResponseEntity<Cow> updateCow(@PathVariable("id") Long id,
                                       @RequestBody Cow cow) {
    Cow oldCow = cowRepository.getOne(id);
    oldCow.setDateOfBirth(cow.getDateOfBirth());
    oldCow.setForMeat(cow.isForMeat());
    oldCow.setForMilk(cow.isForMilk());
    oldCow.setHouse(cow.getHouse());
    oldCow.setName(cow.getName());
    final Cow updatedCow = cowRepository.save(oldCow);
    return ResponseEntity.ok(updatedCow);
  }

  @PutMapping("/pigs/{id}")
  public ResponseEntity<Pig> updatePig(@PathVariable("id") Long id,
                                       @RequestBody Pig pig)
  throws NotFound{
    Pig oldPig = pigRepository.getOne(id);
    oldPig.setDateOfBirth(pig.getDateOfBirth());
    oldPig.setForMeat(pig.isForMeat());
    oldPig.setForBreed(pig.isForBreed());
    oldPig.setHouse(pig.getHouse());
    oldPig.setName(pig.getName());
    final Pig updatedPig = pigRepository.save(oldPig);
    return ResponseEntity.ok(updatedPig);
  }

  @DeleteMapping("/pigs/{id}")
  public Map<String, Boolean> deletePig(@PathVariable("id") Long id){
    pigRepository.deleteById(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

  @DeleteMapping("/{id}")
  public Map<String, Boolean> deleteHouse(@PathVariable("id") Long id){
    houseRepository.deleteById(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/cow/{id}")
  public Map<String, Boolean> deleteCow(@PathVariable("id") Long id){
    cowRepository.deleteById(id);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
