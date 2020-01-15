package com.thinktag.user.controller;

import com.thinktag.user.model.NewPassword;
import com.thinktag.user.model.User;
import com.thinktag.user.service.JwtClientAdapter;
import com.thinktag.user.service.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserProfileController {


    @PostMapping("api/change-password")
    void changePassword(@RequestBody NewPassword user, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        Objects.equals(userDetails.getUsername(), user.getUsername());

        //TODO check the username matches and implement change password functionality

    }
}