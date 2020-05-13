import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String serializeValueName;
    private transient int nonSerializeValueSalary;
    private transient Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSerializeValueName() {
        return serializeValueName;
    }
    public void setSerializeValueName(String serializeValueName) {
        this.serializeValueName = serializeValueName;
    }
    public int getNonSerializeValueSalary() {
        return nonSerializeValueSalary;
    }
    public void setNonSerializeValueSalary(int nonSerializeValueSalary) {
        this.nonSerializeValueSalary = nonSerializeValueSalary;
    }
    @Override
    public String toString() {
        return "Employee [serializeValueName=" + serializeValueName + "]";
    }
}
