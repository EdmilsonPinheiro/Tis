package com.api.queviagem.exceptions.Users;

import com.api.queviagem.exceptions.ApiRequestException;

public class UserNotFoundException {
    public static void throwException() {
        throw new ApiRequestException("Usuário não encontrado.");
    }
}
