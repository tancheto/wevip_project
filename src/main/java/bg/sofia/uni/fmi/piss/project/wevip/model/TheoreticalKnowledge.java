package bg.sofia.uni.fmi.piss.project.wevip.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TheoreticalKnowledge {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = " name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "theoreticalKnowledge", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Task> tasks;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return String.format("Theoretical knowledge[id=%d, name='%s']", id, name);
    }
}
