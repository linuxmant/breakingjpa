package ar.com.elegantsoft.breakingjpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cname;

    @ManyToOne
    private Parent parent;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<GreatChild> greatChildren;

    public Child() {
    }

    public Child(String name, Parent p) {
        setCname(name);
        setParent(p);
    }

    /* getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<GreatChild> getGreatChildren() {
        if(this.greatChildren == null) {
            this.greatChildren = new ArrayList<>();
        }
        return greatChildren;
    }

    public void setGreatChildren(List<GreatChild> greatChildren) {
        this.greatChildren = greatChildren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Child)) return false;
        Child child = (Child) o;
        return getCname().equals(child.getCname()) &&
              getParent().equals(child.getParent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCname(), getParent());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Child{");
        sb.append("id=").append(getId());
        sb.append(", cname='").append(getCname()).append('\'');
        sb.append(", parent=").append(getParent().getId());
        sb.append(", greatChildren=").append(getGreatChildren());
        sb.append('}');
        return sb.toString();
    }
}
