package br.com.evertontrindade.h2connectionexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.evertontrindade.h2connectionexample.beans.LogDate;

public interface LogDateRepository extends JpaRepository<LogDate, Long> {

}
