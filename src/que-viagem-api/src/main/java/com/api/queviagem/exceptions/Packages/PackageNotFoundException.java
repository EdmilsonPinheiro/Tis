package com.api.queviagem.exceptions.Packages;

import com.api.queviagem.exceptions.ApiRequestException;

public class PackageNotFoundException {
    public static void throwException() {
        throw new ApiRequestException("Pacote não encontrado.");
    }
}
