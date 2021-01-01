package bg.sofia.uni.fmi.piss.project.wevip.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Part {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = " name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "part", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Difficulty> difficulties;

    @OneToMany(mappedBy = "part", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Task> tasks;

    public Part() {

    }

    public Part(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Difficulty> getDifficulties() {
        return difficulties;
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

    public void setDifficulties(List<Difficulty> difficulties) {
        this.difficulties = difficulties;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return String.format("Part[id=%d, name='%s']", id, name);
    }
}
