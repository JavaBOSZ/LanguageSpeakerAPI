package me.szydelko.languagespeakerapi.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "use_id")
    private Long id;
    @Column(nullable = false,unique = true)
    private String sub;
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_use_id",referencedColumnName = "use_id")
    @JoinColumn(name = "user_id")
    private List<Page> pages = new ArrayList<>();
    public boolean addPage(Page e){
       return pages.add(e);
    }
}
