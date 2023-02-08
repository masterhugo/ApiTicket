package co.doublev.apitransactions.api;

import co.doublev.apitransactions.business.ControllerBusiness;
import co.doublev.apitransactions.dto.TicketRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class ApiController {

	@Autowired
	ControllerBusiness controllerBusiness;
	
	@Value("${spring.application.version}")
	private String version;

	@GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }
	
	@GetMapping("/ticket/{page}/{items}")
    public ResponseEntity<?> getAccounts(@PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findAllTickets(page,items), HttpStatus.OK);
	}

	@GetMapping("/ticket/{userId}/{page}/{items}")
	public ResponseEntity<?> getAccountsByUserId(@PathVariable("userId") String userId, @PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findTicketsByUserId(userId,page,items), HttpStatus.OK);
	}

	@GetMapping("/ticket/{userId}/{status}/{page}/{items}")
	public ResponseEntity<?> getAccountsByUserIdAndStatus(@PathVariable("userId") String userId, @PathVariable("status") Boolean status, @PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findTicketsByUserIdAndStatus(userId,status,page,items), HttpStatus.OK);
	}

	@GetMapping("/ticket/{status}/{page}/{items}")
	public ResponseEntity<?> getAccountsByStatus(@PathVariable("status") Boolean status, @PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findTicketsByStatus(status,page,items), HttpStatus.OK);
	}

	@GetMapping("/ticket/{creationDate}/{page}/{items}")
	public ResponseEntity<?> getAccountsByCreationDate(@PathVariable("creationDate") Date creationDate, @PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findTicketsByCreationDate(creationDate,page,items), HttpStatus.OK);
	}

	@GetMapping("/ticket/{creationDate}/{status}/{page}/{items}")
	public ResponseEntity<?> getAccountsByCreationDateAndStatus(@PathVariable("creationDate") Date creationDate, @PathVariable("status") Boolean status, @PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findTicketsByCreationDateAndStatus(creationDate,status,page,items), HttpStatus.OK);
	}

	@GetMapping("/ticket/{dateBegin}/{dateEnd}/{page}/{items}")
	public ResponseEntity<?> getAccountsByCreationDateBetween(@PathVariable("dateBegin") Date dateBegin, @PathVariable("dateEnd") Date dateEnd, @PathVariable("page") int page, @PathVariable("items") int items) {
		return new ResponseEntity(controllerBusiness.findTicketsByCreationDateBetween(dateBegin,dateEnd,page,items), HttpStatus.OK);
	}

	@PostMapping("/ticket")
	public ResponseEntity<?> createTicket(@RequestBody TicketRequestDTO ticketRequestDTO) {
		controllerBusiness.createTicket(ticketRequestDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PutMapping("/ticket/{ticketId}")
	public ResponseEntity<?> updateTicket(@PathVariable("ticketId") UUID ticketId, @RequestBody TicketRequestDTO ticketRequestDTO) {
		controllerBusiness.updateTicket(ticketId, ticketRequestDTO);
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/ticket/{ticketId}")
	public ResponseEntity<?> deleteTicket(@PathVariable("ticketId") UUID ticketId) {
		controllerBusiness.deleteTicket(ticketId);
		return new ResponseEntity(HttpStatus.OK);
	}


}
