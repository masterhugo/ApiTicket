package co.doublev.apitransactions.repository;

import co.doublev.apitransactions.model.TicketEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, UUID> {


    Page<TicketEntity> findAll(Pageable pageable);
    @Query("SELECT a FROM TicketEntity a WHERE a.userId = ?1")
    Page<TicketEntity> findByUserId(String userId, Pageable pageable);

    @Query("SELECT a FROM TicketEntity a WHERE a.userId = ?1 AND a.status = ?2")
    Page<TicketEntity> findByUserIdAndStatus(String userId, Boolean status, Pageable pageable);

    @Query("SELECT a FROM TicketEntity a WHERE a.status = ?1")
    Page<TicketEntity> findByStatus(Boolean status, Pageable pageable);

    @Query("SELECT a FROM TicketEntity a WHERE a.creationDate = ?1")
    Page<TicketEntity> findByCreationDate(Date creationDate, Pageable pageable);

    @Query("SELECT a FROM TicketEntity a WHERE a.creationDate = ?1 AND a.status = ?2")
    Page<TicketEntity> findByCreationDateAndStatus(Date creationDate, Boolean status, Pageable pageable);

    @Query("SELECT a FROM TicketEntity a WHERE a.creationDate BETWEEN ?1 AND ?2")
    Page<TicketEntity> findByCreationDateBetween(Date creationDate1, Date creationDate2, Pageable pageable);

}
