package com.example.firstspringproject.controllers;

import com.example.firstspringproject.dao.UserDAO;
import com.example.firstspringproject.models.User;
import com.example.firstspringproject.models.dto.UserRequestDTO;
import com.example.firstspringproject.models.dto.UserResponseDTO;
import com.example.firstspringproject.services.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserDAO userDao;
    private UserService userService;

    @PostMapping("/registration")
    public void register(@RequestBody UserRequestDTO userRequestDto) {
        User user = new User();
        user.setLogin(userRequestDto.getLogin());
        user.setPassword(userRequestDto.getPass());
        System.out.println(user);
        userDao.save(user);
    }

    @GetMapping("/activate/{id}")
    public String activate(@PathVariable int id) {
        Optional<User> findById = userDao.findById(id);
        User user = findById.get();
        user.setActivated(true);
        userDao.save(user);
        return "User activated";
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        String login = userRequestDTO.getLogin();
        String pass = userRequestDTO.getPass();
        User user = userDao.findUserByLoginAndPassword(login, pass);
        System.out.println(user);
        if (user == null) {
            throw new Exception();
        }
        String token = userService.tokenazer(user);
        user.setToken(token);
        userDao.save(user);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("token", token);
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setLogin(user.getLogin());
        return new ResponseEntity<UserResponseDTO>(userResponseDTO, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/modify")
    public void modify(HttpRequest httpRequest) {
        HttpHeaders headers = httpRequest.getHeaders();
        System.out.println(headers);
    }
}
