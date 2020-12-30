package bg.startit.hackathon.airquiality.model;


import java.time.OffsetDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import org.apache.tomcat.jni.Poll;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AirQuality {

  @Id
  //Auto-generate ID
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airGenerator")
  @SequenceGenerator(name = "airGenerator", initialValue = 100)

  private Long id;

  // where
  @NotBlank
  @Size(min = 2, max = 2)
  private String country; // network_countrycode
  @NotBlank
  private String stationName; // station_name
  @NotBlank
  private String stationCode; // station_code

  // what
  @NotNull
  @Enumerated(EnumType.STRING)
  private Pollutant pollutant; // pollutant
  @NotBlank
  private String unit; // value_unit
  private double value; // value_numeric

  // when
  @NotNull
  private OffsetDateTime timestamp; // value_datetime_inserted = 2020-11-02 07:34:10+01:00

  public enum Pollutant {
    //TODO fix the value

    CO(10, ""),
    C6H5_CH3(10, ""),
    PM10(10, ""),
    H2S(10, ""),
    NO(10, ""),
    PM2_5(10, ""),
    SO2(10, ""),
    C6H6(10, ""),
    NOX(10, ""),
    NM3(10, ""),
    NO2(10, ""),
    C6H4_CH3(10, ""),
    NH3(10, ""),
    NOX_as_NO2(10, ""),
    O3(10, "");

    private final String description;
    private final double max;

    Pollutant(double max, String description) {
      this.max = max;
      this.description = description;
    }

    public String getDescription() {
      return description;
    }

    public double getMax() {
      return max;
    }
  }

}
