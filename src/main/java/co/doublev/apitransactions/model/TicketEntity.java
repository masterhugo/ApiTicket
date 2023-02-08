package co.doublev.apitransactions.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue
    @Column(name = "ticket_id")
    private UUID ticketId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "status")
    private Boolean status;
}
