package stenden.farm.data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import stenden.farm.data.Animal;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Cow")
@Entity
public class Cow implements Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "COW_ID")
  private Long id;

  @Column(name = "DATE_OF_BIRTH")
  private Date dateOfBirth;

  @Column(name = "NAME")
  private String Name;

  @Column(name = "MILK_COW")
  private boolean forMilk;

  @Column(name = "MEAT_COW")
  private boolean forMeat;

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

  public boolean isForMilk() {
    return forMilk;
  }

  public void setForMilk(boolean forMilk) {
    this.forMilk = forMilk;
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
