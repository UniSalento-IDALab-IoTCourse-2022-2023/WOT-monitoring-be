package it.unisalento.iot.monitoringbe.domains;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document("user")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

  @Id private String id;
  @CreatedDate private Date date;
  private String name;
  private String surname;
  private String email;
  private String address;
  private String boilerId;
}
