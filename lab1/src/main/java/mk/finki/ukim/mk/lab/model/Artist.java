package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Artist {
    public Long id;
    public String firstName;
    public String lastName;
    public String bio;
}
