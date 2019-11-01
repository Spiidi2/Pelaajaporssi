package com.app.pelaajaporssi.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
	Optional<Message> findByMessagetext(String message);
}
