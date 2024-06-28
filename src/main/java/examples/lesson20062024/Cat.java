package examples.lesson20062024;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;

/*public void setAdditionalInfo(String additionalInfo) {this.setAdditionalInfo(String) additionalInfo;}

//private Habit habit;

@JsonIgnoreType
public static class Habit{
    private String name;
    private String description;
    private boolean good;
}

//@JsonIdentityInfo(generator = ObjectIdGenerator.PropertyGenerator.class, property = "id")
//в строку не будут включены

//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Cat extends Identity {

    @JsonProperty(value = "name_in_json")
    private String name;
    private int age;
    private Color color;

    //@JsonIgnore
    //@JsonBackReference // исключаем из сериализации
    private Category category; //
    //private List<Habit> habits = new ArrayList<>();

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDateTime birth;

    @JsonIgnore //поле не будет участвовать в json
    private String additionalInfo;*/

