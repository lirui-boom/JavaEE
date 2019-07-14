package cn.hehewocao.POJO;

import java.util.Date;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String sex;
    private String birthday;
    private String phone;
    private String email;
    private String address;
    private String occupation;
    private String describes;

    public User() {
    }

    public User(Integer id, String username, String password, String nickname, String sex, String birthday, String phone, String email, String address, String occupation, String describes) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.occupation = occupation;
        this.describes = describes;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describe) {
        this.describes = describe;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", occupation='" + occupation + '\'' +
                ", describes='" + describes + '\'' +
                '}';
    }
}
