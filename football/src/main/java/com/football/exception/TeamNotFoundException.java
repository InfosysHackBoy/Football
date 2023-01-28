package com.football.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Team does not exist with that ID")
public class TeamNotFoundException extends EntityNotFoundException {
	
	

}
