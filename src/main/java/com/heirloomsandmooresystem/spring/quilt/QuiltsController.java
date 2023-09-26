package com.heirloomsandmooresystem.spring.quilt;

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
import org.springframework.web.bind.annotation.RestController;

//import com.heirloomsandmooresystem.spring.client.Client;
//import com.heirloomsandmooresystem.spring.client.ClientRepository;
@CrossOrigin
@RestController
@RequestMapping("/api/quilts")
public class QuiltsController {

	@Autowired
	private QuiltRepository quiRepo;
	//private ClientRepository cliRepo;
	
	//Get All
	@GetMapping
	public ResponseEntity<Iterable<Quilt>> getQuilt(){
		Iterable<Quilt> quil= quiRepo.findAll();
		return new ResponseEntity<Iterable<Quilt>>(quil, HttpStatus.OK);
	}
	//Get By Id
	@GetMapping("{id}")//get by id
	public ResponseEntity<Quilt> getQuilt(@PathVariable int id){
		if(id <= 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
		Optional<Quilt> qui = quiRepo.findById(id);
		if(qui.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Quilt>(qui.get(), HttpStatus.OK);
	}
	
	//Get By New
	@GetMapping("new")
	public ResponseEntity<Iterable<Quilt>> getByNew(){
		Iterable<Quilt> qui = quiRepo.findByStatus("New");
		
		return new ResponseEntity<Iterable<Quilt>>(qui, HttpStatus.OK);
	}
		
	
	//Post
		@PostMapping
		public ResponseEntity<Quilt> postQuilt(@RequestBody Quilt qui)  {
			if(qui.getId() != 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			qui = recalculateQuilt(qui);
			
			quiRepo.save(qui);
			return new ResponseEntity<Quilt>(qui, HttpStatus.CREATED);
		}
		
		//Put
		@PutMapping("{id}")
		public ResponseEntity putQuilt(@PathVariable int id, @RequestBody Quilt qui)  {
			if(qui.getId() != id) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			qui = recalculateQuilt(qui);
						
			quiRepo.save(qui);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//PutInProgress
		@PutMapping("inProgress/{id}")
		public ResponseEntity<?> putInProgress(@RequestBody Quilt qui, @PathVariable int id) {
			        
			qui.setStatus("In Progress");
		        		
		      return putQuilt(id, qui);		
		}
						
		//PutCompleted
		@PutMapping("completed/{id}")
		public ResponseEntity<?> putCompleted(@RequestBody Quilt qui, @PathVariable int id) {
					        
			qui.setStatus("Completed");
				        		
		       return putQuilt(id, qui);		
		}
		
		//Delete
		@DeleteMapping("{id}")
		public ResponseEntity deleteQuilt(@PathVariable int id) {
			if(id <= 0) {
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			quiRepo.deleteById(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//other methods
		
		private Quilt recalculateQuilt(Quilt qui) {
	        //Area
			if(qui.getWidth() > 0 && qui.getLength() > 0) {
	        	qui.setArea(qui.getWidth() * qui.getLength());
	        	}
			//Pantograph
	        if(qui.getArea() > 0 && qui.getPantographPrice() > 0) {	
	        	qui.setPantographCost(qui.getArea() * qui.getPantographPrice());
	        	if(qui.getPantographCost() < 60) {
	        		qui.setPantographCost(60);
	        	qui.setSubTotal(qui.getSubTotal() + qui.getPantographCost());
	        	}
	        }
	        //Quilting
	        if(qui.getArea() > 0 && qui.getQuiltingPrice() > 0) {	
	        	qui.setQuiltingCost(qui.getArea() * qui.getQuiltingPrice());
	        	if(qui.getQuiltingCost() < 60) {
	        		qui.setQuiltingCost(60);
	        	qui.setSubTotal(qui.getSubTotal() + qui.getQuiltingCost());
	        	}
	        }
	        //Parimeter
	        if(qui.getWidth() > 0 && qui.getLength() > 0) {
	        	qui.setParimeter((qui.getWidth() * 2) + (qui.getLength() * 2));
	        	}
	        //Binding
	        if(qui.getParimeter() > 0 && qui.getBindingPrice() > 0) {	
	        	qui.setBindingCost(qui.getParimeter() * qui.getBindingPrice());
	        	qui.setSubTotal(qui.getSubTotal() + qui.getBindingCost());
	        }
	        //Calculate Binding Needs
	        if(qui.getBindingPrice() > 0) {
	        	qui.setBindingAmountNeeded(Math.ceil((qui.getParimeter() / 44) * 2.5));
	        }
	        //Setting quilt size
	        if(qui.getWidth() < 24) {
	        	qui.setSize("Table Runner");
	        }
	        if(qui.getWidth() >= 25 && qui.getWidth() <= 35) {
	        	qui.setSize("Baby");
	        }
	        if(qui.getWidth() >= 36 && qui.getWidth() <= 50) {
	        	qui.setSize("Couch");
	        }
	        if(qui.getWidth() >= 51 && qui.getWidth() <= 67) {
	        	qui.setSize("Twin");
	        }
	        if(qui.getWidth() >= 68 && qui.getWidth() <= 80) {
	        	qui.setSize("Full");
	        }
	        if(qui.getWidth() >= 81 && qui.getWidth() <= 90) {
	        	qui.setSize("Queen");
	        }
	        if(qui.getWidth() >= 91 && qui.getWidth() <= 108) {
	        	qui.setSize("King");
	        }
	        //Backing Cost
	        if(qui.getWidth() > 0 && qui.getBackingPrice() > 0) {	
	        	qui.setBackingCost((qui.getWidth() / 36) * qui.getBackingPrice() + 6);
	        	qui.setSubTotal(qui.getSubTotal() + qui.getBackingCost());
	        }
	        //Calculate Backing Needs
	        if(qui.getBackingPrice() > 0) {
	        	qui.setBackingAmountNeeded((qui.getWidth() + 6) / 36);
	        }
	      //Batting Cost
	        if(qui.getWidth() > 0 && qui.getBattingPrice() > 0) {	
	        	qui.setBattingCost((qui.getWidth() / 36) * qui.getBattingPrice() + 6);
	        	qui.setSubTotal(qui.getSubTotal() + qui.getBattingCost());
	        }
	      //Calculate Batting Needs
	        if(qui.getBattingPrice() > 0) {
	        	qui.setBattingAmountNeeded((qui.getWidth() + 6) / 36);
	        }
	        //Embroidery cost
	        if(qui.getEmbroideryCost() > 0) {
	        	qui.setSubTotal(qui.getSubTotal() + qui.getEmbroideryCost());
	        }
	      //Discount
	        if(qui.getDiscountPrice() > 0 && qui.getQuiltingCost() > 0) {	
	        	qui.setDiscountAmount(qui.getQuiltingCost() * qui.getDiscountPrice() );
	        	qui.setSubTotal(qui.getSubTotal() - qui.getDiscountAmount());
	        }
	        if(qui.getDiscountPrice() > 0 && qui.getPantographCost() > 0) {	
	        	qui.setDiscountAmount(qui.getPantographCost() * qui.getDiscountPrice() );
	        	qui.setSubTotal(qui.getSubTotal() - qui.getDiscountAmount());
	        }
	        //Rewards
	        if(qui.getRewardAmount() > 0) {
	        	qui.setSubTotal(qui.getSubTotal() - qui.getRewardAmount());
	        }
	      //Tax Calculator
	        if(qui.getSubTotal() > 0) {	
	        	qui.setTaxAmount(qui.getSubTotal() * qui.getTax());
	        	qui.setTotalDue(qui.getSubTotal() + qui.getTaxAmount());
	        }
	        //Downpayment
	        if(qui.getDownpayment() > 0) {	
	        	qui.setDownpaymentAmount(qui.getDownpayment());
	        	qui.setTotalDue(qui.getTotalDue() - qui.getDownpaymentAmount());
	        }
	        //Tip
	        if(qui.getTip() > 0) {	
	        	qui.setTipAmount(qui.getTip());
	        	qui.setTotalDue(qui.getTotalDue() + qui.getTipAmount());
	        }
	        
	      //Points tracker
	       //***********************working on point calculator*************************
			if(qui.getQuiltingCost() > 0) {
				qui.getClient().setPoints(qui.getQuiltingCost());
			}
	        
			return qui;
				
	}
		
		
		
		
	
}
