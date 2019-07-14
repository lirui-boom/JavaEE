package cn.hehewocao.POJO;

public class Admin {
    private String id;
    private String administrator;
    private String password;

    public Admin() {
    }

    public Admin(String id, String administrator, String password) {
        this.id = id;
        this.administrator = administrator;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdministrators() {
        return administrator;
    }

    public void setAdministrators(String administrator) {
        this.administrator = administrator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", administrator='" + administrator + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
