package com.pluralsight.web;

import com.pluralsight.entity.Application;
import com.pluralsight.entity.Epic;
import com.pluralsight.entity.Ticket;
import com.pluralsight.exception.ApplicationNotFoundException;
import com.pluralsight.service.ApplicationService;
import com.pluralsight.service.EpicService;
import com.pluralsight.service.ReleaseService;
import com.pluralsight.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tza")
public class TzaController {
    private ApplicationService applicationService;
    private TicketService ticketService;
    @Autowired
    private EpicService epicService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) { this.applicationService = applicationService; }

    @Autowired
    public void setTicketService(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    //public void setEpicService(EpicService epicService) {
    //	this.epicService = epicService;
    //}

    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> list = ticketService.listTickets();
        return new ResponseEntity<List<Ticket>>(list, HttpStatus.OK);
    }
    
    @GetMapping("/epics")
    public ResponseEntity<List<Epic>> getEpics(){
    	List<Epic> epics  = epicService.listEpics();
    	return new ResponseEntity<List<Epic>>(epics,HttpStatus.OK); 
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> list = applicationService.listApplications();
        return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
    }

    @GetMapping("/application/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Application>(applicationService.findApplication(id), HttpStatus.OK);
        } catch (ApplicationNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application Not Found");
        }
    }
}