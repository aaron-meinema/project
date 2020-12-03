package stenden.farm.data.model;


import lombok.Data;
import stenden.farm.data.Animal;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "Pig")
@Entity
public class Pig implements Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "PIG_ID")
  private Long id;

  @Column(name = "DATE_OF_BIRTH")
  private Date dateOfBirth;

  @Column(name = "NAME")
  private String Name;

  @Column(name = "MEAT_PIG")
  private boolean forMeat;

  @Column(name = "BREED_PIG")
  private boolean forBreed;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "HOUSE_ID")
  private House house;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  @Override
  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public boolean isForBreed() {
    return forBreed;
  }

  public void setForBreed(boolean forBreed) {
    this.forBreed = forBreed;
  }

  public boolean isForMeat() {
    return forMeat;
  }

  public void setForMeat(boolean forMeat) {
    this.forMeat = forMeat;
  }

  public House getHouse() {
    return house;
  }

  public void setHouse(House house) {
    this.house = house;
  }
}
