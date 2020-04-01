package ar.com.elegantsoft.breakingjpa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class GreatChild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String gcname;

    @ManyToOne
    private Child child;

    public GreatChild() {
    }

    public GreatChild(String name, Child c) {
        setGcname(name);
        setChild(c);
    }

    /* getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGcname() {
        return gcname;
    }

    public void setGcname(String gcname) {
        this.gcname = gcname;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GreatChild)) return false;
        GreatChild that = (GreatChild) o;
        return getGcname().equals(that.getGcname()) &&
              getChild().equals(that.getChild());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGcname(), getChild());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GreatChild{");
        sb.append("id=").append(getId());
        sb.append(", gcname='").append(getGcname()).append('\'');
        sb.append(", child=").append(getChild().getId());
        sb.append('}');
        return sb.toString();
    }
}
