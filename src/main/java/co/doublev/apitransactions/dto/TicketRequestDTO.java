package co.doublev.apitransactions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketRequestDTO {
    private UUID ticketId;
    private String userId;
    private Boolean status;
    private int page;
    private int elements;

}
