package com.example.demo.controller;

class customerNotfoundException extends RuntimeException {

    customerNotfoundException(Long id) {
        super("Could not find customer " + id);
    }
}
