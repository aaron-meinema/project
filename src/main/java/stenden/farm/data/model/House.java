package stenden.farm.data.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "House")
@Entity
public class House  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
  private List<Cow> cows;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "house")
  private List<Pig> pigs;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<Cow> getCows() {
    return cows;
  }

  public void setCows(List<Cow> cows) {
    this.cows = cows;
  }

  public List<Pig> getPigs() {
    return pigs;
  }

  public void setPigs(List<Pig> pigs) {
    this.pigs = pigs;
  }
}
