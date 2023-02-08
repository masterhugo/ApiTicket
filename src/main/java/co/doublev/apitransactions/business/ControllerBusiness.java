package co.doublev.apitransactions.business;

import co.doublev.apitransactions.dto.TicketRequestDTO;
import co.doublev.apitransactions.enums.ErrorEnum;
import co.doublev.apitransactions.exceptions.ApiException;
import co.doublev.apitransactions.model.TicketEntity;
import co.doublev.apitransactions.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
public class ControllerBusiness {

    @Autowired
    TicketRepository ticketRepository;

    public Page<TicketEntity> findAllTickets(int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findAll(pageable);
        return ticketEntityPage;
    }

    public Page<TicketEntity> findTicketsByUserId(String userId, int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findByUserId(userId, pageable);
        return ticketEntityPage;
    }

    public Page<TicketEntity> findTicketsByUserIdAndStatus(String userId, Boolean status, int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findByUserIdAndStatus(userId, status, pageable);
        return ticketEntityPage;
    }

    public Page<TicketEntity> findTicketsByStatus(Boolean status, int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findByStatus(status, pageable);
        return ticketEntityPage;
    }

    public Page<TicketEntity> findTicketsByCreationDate(Date searchDate, int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findByCreationDate(searchDate, pageable);
        return ticketEntityPage;
    }

    public Page<TicketEntity> findTicketsByCreationDateAndStatus(Date searchDate,Boolean status, int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findByCreationDateAndStatus(searchDate, status, pageable);
        return ticketEntityPage;
    }

    public Page<TicketEntity> findTicketsByCreationDateBetween(Date searchDateBegin,Date searchDateEnd, int page, int items) throws ApiException{
        Pageable pageable = PageRequest.of(page, items);
        Page<TicketEntity> ticketEntityPage = ticketRepository.findByCreationDateBetween(searchDateBegin, searchDateEnd, pageable);
        return ticketEntityPage;
    }

    public void createTicket(TicketRequestDTO ticketRequestDTO) throws ApiException{
        if(ticketRequestDTO.getUserId() == null || ticketRequestDTO.getUserId().isEmpty()){
            throw new ApiException(ErrorEnum.USER_ID_IS_REQUIRED, "User Id is required");
        }
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setUserId(ticketRequestDTO.getUserId());
        ticketEntity.setCreationDate(Date.from(Instant.now()));
        ticketEntity.setStatus(true);
        ticketRepository.save(ticketEntity);
    }

    public void updateTicket(UUID ticketId, TicketRequestDTO ticketRequestDTO) throws ApiException{
        if(ticketRequestDTO.getTicketId() == null || ticketRequestDTO.getTicketId().toString().isEmpty()){
            throw new ApiException(ErrorEnum.TICKET_ID_IS_REQUIRED, "Ticket Id is required");
        }
        TicketEntity ticketEntity = ticketRepository.findById(ticketRequestDTO.getTicketId()).orElseThrow(() -> new ApiException(ErrorEnum.TICKET_NOT_FOUND, "Ticket not found"));
        ticketEntity.setUserId(ticketRequestDTO.getUserId());
        ticketEntity.setStatus(ticketRequestDTO.getStatus());
        ticketRepository.save(ticketEntity);
    }

    public void deleteTicket(UUID ticketId) throws ApiException{
        if(ticketId == null || ticketId.toString().isEmpty()){
            throw new ApiException(ErrorEnum.TICKET_ID_IS_REQUIRED, "Ticket Id is required");
        }
        TicketEntity ticketEntity = ticketRepository.findById(ticketId).orElseThrow(() -> new ApiException(ErrorEnum.TICKET_NOT_FOUND, "Ticket not found"));
        ticketRepository.delete(ticketEntity);
    }

}
