package br.com.fiap.SystemManagement_V10.models;

public record Token(
    String token,
    String type,
    String prefix
) {}