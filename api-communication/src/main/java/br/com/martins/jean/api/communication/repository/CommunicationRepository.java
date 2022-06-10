package br.com.martins.jean.api.communication.repository;

import br.com.martins.jean.api.communication.domain.CommunicationDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationDomain, String> {
}
