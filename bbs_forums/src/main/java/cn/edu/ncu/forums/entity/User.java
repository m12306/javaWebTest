package cn.edu.ncu.forums.entity;

import javax.persistence.*;

/**
 * Description: 用户/管理员实体类
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/14 21:46
 * @version : 1.0
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String username;

    @Column(length = 18, nullable = false)
    private String password;

    @Column(length = 11)
    private String phone;

    @Column(length = 40)
    private String work;//工作

    @Column(length = 50)
    private String address;

    @Column(length = 40, nullable = false)
    private String image;//头像

    @Column(length = 20, nullable = false)
    private String authority;//权限，admin or user

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                ", image='" + image + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
