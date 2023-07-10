package it.unisalento.iot.monitoringbe.dto;

import it.unisalento.iot.monitoringbe.domains.AlarmType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class AlarmDTO {

  @Id private String id;
  @CreatedDate private Date date;
  private AlarmType alarmType;
  private String boilerId;
}
