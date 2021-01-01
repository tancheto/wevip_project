package bg.sofia.uni.fmi.piss.project.wevip.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Difficulty {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = " name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "part_id")
    private Part part;

    @OneToMany(mappedBy = "difficulty", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    public Difficulty() {

    }

    public Difficulty(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Part getPart() {
        return part;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return String.format("Difficulty[id=%d, name='%s']", id, name);
    }
}
