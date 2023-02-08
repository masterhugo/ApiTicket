package co.doublev.apitransactions.business;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import co.doublev.apitransactions.model.TicketEntity;
import co.doublev.apitransactions.repository.TicketRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class ControllerBusinessTest {
    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private ControllerBusiness controllerBusiness;

    @BeforeEach
    void init() {
        Pageable pageable = PageRequest.of(1, 5);

        Page<TicketEntity> tickets = new PageImpl<>(Arrays.asList(
                new TicketEntity(UUID.randomUUID(),"1",null,null,true),
                new TicketEntity(UUID.randomUUID(),"1",null,null,true),
                new TicketEntity(UUID.randomUUID(),"1",null,null,true),
                new TicketEntity(UUID.randomUUID(),"1",null,null,true)
        ));


        when(ticketRepository.findAll(pageable)).thenReturn(tickets);
        when(ticketRepository.findByUserId(anyString(),any())).thenReturn(Page.empty());
        when(ticketRepository.findByUserIdAndStatus(anyString(),any(),any())).thenReturn(Page.empty());
        when(ticketRepository.findByStatus(any(),any())).thenReturn(Page.empty());
        when(ticketRepository.findByCreationDate(any(),any())).thenReturn(Page.empty());
        when(ticketRepository.findByCreationDateAndStatus(any(),any(),any())).thenReturn(Page.empty());
        when(ticketRepository.findByCreationDateBetween(any(),any(),any())).thenReturn(Page.empty());

        when(ticketRepository.findById(any())).thenReturn(Optional.of(TicketEntity.builder()
                .ticketId(UUID.randomUUID())
                .userId("1")
                .creationDate(null)
                .updateDate(null)
                .status(true)
                .build()));



    }
    @Test
    public void should_find_tutorial_by_id() throws Exception {
        ticketRepository.findById(UUID.randomUUID());
        Assertions.assertTrue(true);
    }

    @Test
    public void should_find_ticket_by_id() throws Exception {

        Page tickets = controllerBusiness.findAllTickets(1, 5);

        Assertions.assertEquals(4, tickets.getTotalElements());
        //Assertions.assertEquals("1", ticketRepository.findById(UUID.randomUUID()).get().getTicketId());
    }

    @Test
    public void should_find_tickets_by_userId() throws Exception {
        ticketRepository.findById(UUID.randomUUID());
        //Assertions.assertEquals("1", ticketRepository.findById(UUID.randomUUID()).get().getTicketId());
    }

    @AfterEach
    void afterMethod(){
        System.out.println("After each method");
    }

}
