package ar.com.elegantsoft.breakingjpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String pname;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    private
    List<Child> children;

    public Parent() {
    }

    public Parent(String name) {
        setPname(name);
    }

    /* getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<Child> getChildren() {
        if(this.children == null) {
            setChildren(new ArrayList<>());
        }
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;
        Parent parent = (Parent) o;
        return getId().equals(parent.getId()) &&
              getPname().equals(parent.getPname()) &&
              getChildren().equals(parent.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPname());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Parent{");
        sb.append("id=").append(getId());
        sb.append(", pname='").append(getPname()).append('\'');
        sb.append(", children=").append(getChildren());
        sb.append('}');
        return sb.toString();
    }
}
