package pl.andrzejmidura.fivehanddrawpoker.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "credits")
    private int credits;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @OneToMany
    @JoinColumn(name = "username")
    private Set<GameHistory> gameHistorySet;


    public User() {}

    public User(String username, String email, String password, int credits) {
        this(username, email, password, credits, true);
    }

    public User(String username, String email, String password, int credits, boolean accountNonLocked) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.credits = credits;
        this.accountNonLocked = accountNonLocked;
        this.gameHistorySet = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<GameHistory> getGameHistorySet() {
        return gameHistorySet;
    }

    public void setGameHistorySet(Set<GameHistory> gameHistorySet) {
        this.gameHistorySet = gameHistorySet;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", credits=" + credits +
                ", gameHistorySet=" + gameHistorySet +
                '}';
    }
}
