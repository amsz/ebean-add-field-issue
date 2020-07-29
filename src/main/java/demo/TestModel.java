package demo;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class TestModel extends Model implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  Integer id;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  // Before run2
  /*String field1;

  public String getField1() {
    return field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }*/

}
