package com.example.myapp.login;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.myapp.User;

public class LoginUserDetails implements UserDetails {

	private User user;  // Userオブジェクトを保持します。

    // コンストラクタでUserオブジェクトを受け取り、それをこのクラスのuserにセットします。
    public LoginUserDetails(User user) {
        this.user = user;
    }

    // ユーザーに与えられる権限を返します。ここでは全てのユーザーに"general"という権限を与えています。
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("general"));
    }

    // Userオブジェクトのパスワードを返します。
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // Userオブジェクトのユーザー名を返します。
    @Override
    public String getUsername() {
        return user.getUsername();
    }
    
    

    // アカウントが有効期限切れでないことを示すために、常にtrueを返します。
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // アカウントがロックされていないことを示すために、常にtrueを返します。
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 資格情報（ここではパスワード）が有効期限切れでないことを示すために、常にtrueを返します。
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // アカウントが有効であることを示すために、常にtrueを返します。
    @Override
    public boolean isEnabled() {
        return true;
    }
}
