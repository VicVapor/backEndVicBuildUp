package com.vic.backendvicbuildup.repositories;

public interface EncryptRepository {
    //Encripta la contraseña
    String encryptPassword(String password);

    //Verifica si la contraseña original es igual a la contraseña encriptada
    boolean verifyPassword(String originalPassword, String hashPassword);

}
