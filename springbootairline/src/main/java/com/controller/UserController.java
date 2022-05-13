package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Feedback;
import com.entity.Flights;
import com.entity.Offers;
import com.entity.Promotion;
import com.entity.User;
import com.repository.FeedbackRepository;
import com.repository.FlightsRepository;
import com.repository.OffersRepository;
import com.repository.PromotionRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {
	
	//FLIGHT
	@Autowired
	private FlightsRepository flightsRepo;
	
	@GetMapping("/allflight")
	private List<Flights> getAllFlights() {
		List<Flights> flightList = flightsRepo.findAll();
		System.out.println(flightList);
		return flightsRepo.findAll();
	}
	
	@PostMapping("/createflight")
	private Flights createFlight(@RequestBody Flights flight) {
		System.out.println(flight);
		return flightsRepo.save(flight);
	}
	
	@GetMapping("/ticketdata/{id}")
	public Optional<Flights> getTicketData(@PathVariable Long id) {
		return flightsRepo.findById(id);
	}
	
	@PutMapping("/updateflight")
	public Flights updateFlight(@RequestBody Flights flight) {
		return flightsRepo.save(flight);
	}
	

	@DeleteMapping("/deleteflight/{id}")
	public ResponseEntity<HttpStatus> deleteFlight(@PathVariable Long id) {
		flightsRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	//USER
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/alluser")
	private List<User> getAllUsers() {
		List<User> userList = userRepo.findAll();
		System.out.println(userList);
		return userRepo.findAll();
	}
	
	@PostMapping("/createuser")
	private User createUser(@RequestBody User user) {
		System.out.println(user);
		return userRepo.save(user);
	}
	
	@PutMapping("/updateuser")
	public User updareOffer(@RequestBody User user) {
		return userRepo.save(user);
	}
	
	//OFFER
	@Autowired
	private OffersRepository offerRepo;
	
	@GetMapping("/alloffers")
	private List<Offers> getAllOffers(){
		List<Offers> offerList = offerRepo.findAll();
		System.out.println(offerList);
		return offerRepo.findAll();
	}
	
	@PostMapping("/createoffer")
	private Offers createOffer(@RequestBody Offers offer) {
		System.out.println(offer);
		return offerRepo.save(offer);
	}
	
	@GetMapping("/offerbyid/{id}")
	public Optional<Offers> getOfferById(@PathVariable int id) {
		return offerRepo.findById(id);
	}
	
	@PutMapping("/updateoffer")
	public Offers updareOffer(@RequestBody Offers offer) {
		return offerRepo.save(offer);
	}
	
	@DeleteMapping("/deleteoffer/{id}")
	public ResponseEntity<HttpStatus> deleteOffer(@PathVariable int id) {
		offerRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	//FEEDBACK
	@Autowired
	private FeedbackRepository feedRepo;
	
	@PostMapping("/createfeedback")
	private Feedback createFeedback(@RequestBody Feedback feedback) {
		System.out.println(feedback);
		return feedRepo.save(feedback);
	}
	
	@GetMapping("/allfeedback")
	private List<Feedback> getAllFeedbacks(){
		return feedRepo.findAll();
		
	}
	
	
	//PROMOTION 
	@Autowired
	private PromotionRepository promoRepo;
	
	@GetMapping("/allpromotions")
	private List<Promotion> getAllPromotions(){
		List<Promotion> promoList =promoRepo.findAll();
		System.out.println(promoList);
		return promoRepo.findAll();
	}
	
	@GetMapping("/promotionbyid/{id}")
	public Optional<Promotion> getPromotionById(@PathVariable int id) {
		return promoRepo.findById(id);
	}
	
	@PostMapping("/createpromotion")
	private Promotion createPromotion(@RequestBody Promotion promo) {
		System.out.println(promo);
		return promoRepo.save(promo);
	}	
	
	@PutMapping("/updatepromotion")
	public Promotion updarePromotion(@RequestBody Promotion promotion) {
		return promoRepo.save(promotion);
	}
	

	@DeleteMapping("/deletepromotion/{id}")
	public ResponseEntity<HttpStatus> deletePromotion(@PathVariable int id) {
		promoRepo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
