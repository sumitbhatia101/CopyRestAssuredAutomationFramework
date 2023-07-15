package germany.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Employee {
    private int id;
    private String fname;
    private String lname;
    private String email;
}
