package bd;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_roles", schema = "public", catalog = "postgres")
public class UserRolesEntity {
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "role_id")
    private Integer roleId;
    @Id
    private Long id;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRolesEntity that = (UserRolesEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
