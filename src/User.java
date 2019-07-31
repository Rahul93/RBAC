import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class User {
    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    private List<Role> role;
    private String name;
    private boolean status;
    protected String id;
    private String password;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public abstract Map<String, List<ActionType>> getAllResources();

}