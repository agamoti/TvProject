package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by nimrod_t on 5/15/2017.
 */



public class UserDto {
    private String email;
    @JsonProperty("user_name")
    private String userName;
    private String password;
    private Boolean login;
    private Long id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isLogin() {return login;}

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Long getId() { return id;}

    public void setId(Long id) { this.id = id;}
}
