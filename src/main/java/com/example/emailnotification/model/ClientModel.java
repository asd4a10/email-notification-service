package com.example.emailnotification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    private String clientId;
    private String name;
    private String surname;
    private String email;
}

